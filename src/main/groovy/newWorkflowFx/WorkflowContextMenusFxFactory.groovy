package newWorkflowFx

import core.application.controller.StageController
import core.application.gui.builderFx.ContextMenuFxBuilder
import core.application.gui.factoryFx.DialogFxFactory
import core.application.gui.factoryFx.FileChooserFxFactory
import core.application.gui.workflowFxComponent.model.*
import core.application.gui.workflowFxComponent.param.FileSelect
import core.application.gui.workflowFxComponent.param.ShowDialogEnum
import core.application.gui.workflowFxComponent.view.VertexConnect2dFx
import core.application.gui.workflowFxComponent.view.VertexConnectPropertiesFxStage
import core.application.gui.workflowFxComponent.view.Workflow2dFx
import core.application.gui.workflowFxComponent.view.WorkflowEdge2dFx
import core.application.gui.workflowFxComponent.view.WorkflowEdgePropertiesFxStage
import core.application.gui.workflowFxComponent.view.WorkflowVertexPropertiesFxStage
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.ButtonType
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu
import javafx.stage.Window
import newGui.NotificationsFxFactory

/**
 * factory for creating various type predefined ContextMenu that are used in application
 */
class WorkflowContextMenusFxFactory {

    /**
     * WorkflowVertex2dFx ContextMenu
     * @param v2dFx
     * @return
     */
    static ContextMenu workflowVertexContextMenu(WVertexFx v2dFx){

        EventHandler<ActionEvent> hEditVertex = actionEvent -> {
            WorkflowVertexPropertiesFxStage stg = new WorkflowVertexPropertiesFxStage(null, v2dFx)
            StageController.showStage(stg)
        }

        EventHandler<ActionEvent> hRunProcess = actionEvent -> {
            NotificationsFxFactory.showNotImplemented()
        }

        EventHandler<ActionEvent> hStopProcess = actionEvent -> {
            NotificationsFxFactory.showNotImplemented()
        }

        EventHandler<ActionEvent> hDeleteVertex = actionEvent -> {
            Optional<ButtonType> result = DialogFxFactory.showConfirmDialog(
                    "Do you really want delete Vertex?",
                    "It will remove Node and all own connections from Workflow",
                    "You can't discard that changes. Are you sure?"
            )
            if (result.get() == ButtonType.OK) {
                WorkflowFx wf2dFx = (WorkflowFx)v2dFx.getParent()
                wf2dFx.getChildren().remove(v2dFx)
            }
        }

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Edit vertex properties", null, hEditVertex);
        Menu menuVertexConnectors = contextMenu.withMenu("Vertex connectors", null);
        for (VertexConnect2dFx c2dFx: v2dFx.getConnects2dFx()) {
            contextMenu.withMenuItem("Edit Connector properties:"+c2dFx.getModel().getLabel(),
                    menuVertexConnectors, new hEditVertexConnect(c2dFx));
        }
        contextMenu.withMenuItem("Run process", null, hRunProcess );
        contextMenu.withMenuItem("Stop process", null, hStopProcess );
        contextMenu.withMenuItem("Save to *.wfv", null, new hSaveVertexToFile(v2dFx) );
        contextMenu.withMenuItem("Load from *.wfv", null, new hLoadVertexFromFile(v2dFx) );
        contextMenu.withMenuItem("Delete Vertex", null, hDeleteVertex );
        return contextMenu.build();
    }

    /**
     * WorkflowEdge2dFx ContextMenu
     * @param e2dFx
     * @return
     */
    static ContextMenu workflowEdgeContextMenu(WorkflowEdge2dFx e2dFx){

        EventHandler<ActionEvent> hDeleteEdge = actionEvent -> {
            Optional<ButtonType> result = DialogFxFactory.showConfirmDialog(
                    "Deleting of Edge",
                    "It will remove Edge workflow",
                    "You can't discard that changes. Are you sure?"
            )
            if (result.get() == ButtonType.OK) {
                Workflow2dFx wf2dFx = (Workflow2dFx)e2dFx.getParent();
                WorkflowModel wfModel = wf2dFx.getModel();
                WorkflowEdge e = e2dFx.getModel();
                wf2dFx.removeEdge(e2dFx);
                wfModel.removeEdge(e);
            }
        };

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Edit edge properties", null, e-> {
            WorkflowEdgePropertiesFxStage stg = new WorkflowEdgePropertiesFxStage(null, e2dFx);
            StageController.showStage(stg);
        });
        contextMenu.withMenuItem("delete", null, hDeleteEdge );
        return contextMenu.build();
    }

    /**
     * Workflow2dFx contextMenu
     * @param workflow2dFx
     * @return
     */
    static ContextMenu workflowContextMenu(WorkflowFx workflow2dFx){

        EventHandler<ActionEvent> hSaveWorkflowAs = e ->{
            FileSelect fParam = FileSelect.fileWFS().showDialogType(ShowDialogEnum.SHOW_SAVE_DIALOG)
            Window wnd = workflow2dFx.getScene().getWindow()
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd)
            if(files.size()==1) {
                WorkflowIO.saveWorkflow(workflow2dFx, files.iterator().next())
            }
        }

        EventHandler<ActionEvent> hLoadWorkflow = e ->{
            FileSelect fParam = FileSelect.fileWFS().showDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG)
            Window wnd = workflow2dFx.getScene().getWindow()
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd)
            if(files.size()==1) {
                workflow2dFx = WorkflowIO.loadWorkflow(files.iterator().next())
                NotificationsFxFactory.showNotImplemented()
            }
        }

        EventHandler<ActionEvent> hSaveWorkflow = new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent actionEvent) {
                NotificationsFxFactory.showNotImplemented();
            }
        };

        EventHandler<ActionEvent> hCreateVertexFromFileClass = new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent actionEvent) {
                NotificationsFxFactory.showNotImplemented()
            }
        }

        EventHandler<ActionEvent> hCreateEmptyVertexClass = new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent actionEvent) {
                double x = workflow2dFx.getScene().getX()
                double y = workflow2dFx.getScene().getY()
                WVertexFx newVertex = WVertexFx.create(x, y, EmptyClass.class)
                workflow2dFx.getChildren().add(newVertex)
            }
        }

        EventHandler<ActionEvent> hCreateEmptyVertexObject = new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent actionEvent) {
                double x = workflow2dFx.getScene().getX()
                double y = workflow2dFx.getScene().getY()
                WVertexFx newVertex = WVertexFx.create(x, y, new EmptyClass())
                workflow2dFx.getChildren().add(newVertex)
            }
        }


        EventHandler<ActionEvent> hNewVertexFromFile = new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent actionEvent) {
                FileSelect fParam = FileSelect.fileWFV().showDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG)
                Window wnd = workflow2dFx.getScene().getWindow()
                List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd)
                if(files.size()==1) {
                    WVertexFx v = WorkflowIO.loadWorkflowVertex(files.iterator().next())
                    v.setLayoutXY(wnd.getX(), wnd.getY())
                    workflow2dFx.getChildren().add(v)
                }
            }
        }

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Save Workflow as... *.wfs", null, hSaveWorkflowAs )
        contextMenu.withMenuItem("Save Workflow in *.wfs", null, hSaveWorkflow )
        contextMenu.withMenuItem("Load Workflow from *.wfs", null, hLoadWorkflow )
        contextMenu.withMenuItem("Create Empty WVertex Class", null, hCreateEmptyVertexClass)
        contextMenu.withMenuItem("Create Empty WVertex Object", null, hCreateEmptyVertexObject)
        contextMenu.withMenuItem("Create WorkflowVertex from *.Class", null, hCreateVertexFromFileClass)
        contextMenu.withMenuItem("New WorkflowVertex from *.wfv", null, hNewVertexFromFile)
        return contextMenu.build();
    }

    class hEditVertexConnect implements EventHandler<ActionEvent> {
        private VertexConnect2dFx c2dFx
        hEditVertexConnect(VertexConnect2dFx c2dFx) {
            this.c2dFx = c2dFx
        }
        @Override
        void handle(ActionEvent actionEvent) {
            VertexConnectPropertiesFxStage stg = new VertexConnectPropertiesFxStage(null, c2dFx)
            StageController.showStage(stg)
        }
    }

    class hSaveVertexToFile implements EventHandler<ActionEvent> {
        private WVertexFx vertex2dFx
        hSaveVertexToFile(WVertexFx v2dFx) {
            this.vertex2dFx = v2dFx
        }
        @Override
        void handle(ActionEvent actionEvent) {
            FileSelect fParam = FileSelect.fileWFV().showDialogType(ShowDialogEnum.SHOW_SAVE_DIALOG)
            Window wnd = vertex2dFx.getScene().getWindow()
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd)
            if(files.size()==1) {
                WorkflowIO.saveWorkflowVertex(vertex2dFx, files.iterator().next())
            }
        }
    }

    class hLoadVertexFromFile implements EventHandler<ActionEvent> {
        private WVertexFx vertex2dFx
        hLoadVertexFromFile(WVertexFx v2dFx) {
            this.vertex2dFx = v2dFx
        }
        @Override
        void handle(ActionEvent actionEvent) {
            FileSelect fParam = FileSelect.fileWFV().showDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG)
            Window wnd = vertex2dFx.getScene().getWindow()
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd)
            if(files.size()==1) {
                WVertexFx v = WorkflowIO.loadWorkflowVertex(files.iterator().next())
                WVertexFx prev = vertex2dFx
                v.setLayoutXY(prev.getLayoutX(), prev.getLayoutY())
            }
        }
    }

}