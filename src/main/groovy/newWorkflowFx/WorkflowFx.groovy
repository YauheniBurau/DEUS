package newWorkflowFx

import javafx.event.EventHandler
import javafx.scene.control.ContextMenu
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane

class WorkflowFx extends Pane {
    WVertexConnectorFx newEdge

    WorkflowFx() {
        this.setOnContextMenuRequested(e->{
            ContextMenu cm = WorkflowContextMenusFxFactory.workflowContextMenu(this)
            cm.show(this.getScene().getWindow(), e.getX(), e.getY())
        })
    }

    /**
     Connector handler to connect contacts with cubicCurve edge
     */
    class WVertexConnectorFxHandler implements EventHandler<MouseEvent> {
        WorkflowFx workflowFx
        WVertexConnectorFxHandler(WorkflowFx workflowFx) {
            this.workflowFx = workflowFx
        }
        @Override
        void handle(MouseEvent mouseEvent) {
            if( mouseEvent.isPrimaryButtonDown() ){
                workflowFx.setNewEdge( new WVertexConnectorFx(mouseEvent.x, mouseEvent.y) )
            }
            if( !mouseEvent.isPrimaryButtonDown() ){
                workflowFx.getChildren().add(workflowFx.getNewEdge())
                workflowFx.setNewEdge(null)
            }
            if( !mouseEvent.isDragDetect() ){
                workflowFx.getNewEdge().setEndXY(mouseEvent.x, mouseEvent.y)
            }
        }
    }

}