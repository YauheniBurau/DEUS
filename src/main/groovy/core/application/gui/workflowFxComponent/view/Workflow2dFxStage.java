package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.SceneFxFactory;
import core.application.gui.workflowFxComponent.bean.BeanEmpty;
import core.application.gui.workflowFxComponent.binding.WorkflowFacade;
import newWorkflowFx.WorkflowIO;
import core.application.gui.workflowFxComponent.model.VertexDataBeanTypeEnum;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.zoomDrugScrollFxComponent.ZoomDrugScrollFx;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 03.04.2019
 * refactored to new version 30.06.2020
 */
public class Workflow2dFxStage extends Stage {
    private WorkflowFacade workflowFacade = null;

    public Workflow2dFxStage(Stage owner, WorkflowIO workflowIO) {
        this.workflowFacade = new WorkflowFacade(workflowIO);
        ZoomDrugScrollFx scrollPane = new ZoomDrugScrollFx(this.workflowFacade.getWorkflow2dFx());
        StageFxBuilder stg = new StageFxBuilder(this);
        Scene scene = SceneFxFactory.create(scrollPane, 1024, 640);
        stg.withScene(scene).withTitle("Workflow")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        this.workflowFacade.setCanvasSize(2000, 1500);

        WorkflowVertex wfv1 = WorkflowVertex.newVertex(200, 100, String.class.getName(), new BeanEmpty(), VertexDataBeanTypeEnum.EMPTY );
        this.workflowFacade.addVertex(wfv1);
        WorkflowVertex wfv2 = WorkflowVertex.newVertex(400, 150, String.class.getName(), new BeanEmpty(), VertexDataBeanTypeEnum.EMPTY );
        this.workflowFacade.addVertex(wfv2);
        WorkflowVertex wfv3 = WorkflowVertex.newVertex(600, 50, Integer.class.getName(), new BeanEmpty(), VertexDataBeanTypeEnum.EMPTY );
        this.workflowFacade.addVertex(wfv3);

//        WorkflowVertex wfvEdit1 = WorkflowVertex.newVertex(200, 300, EmptyMethodClass.class.getName(), new BeanInt(100), VertexDataBeanTypeEnum.EDIT );
//        this.workflowFacade.addVertex(wfvEdit1);
//        WorkflowVertex wfvEdit2 = WorkflowVertex.newVertex(450, 300, EmptyMethodClass.class.getName(), new BeanString("test"), VertexDataBeanTypeEnum.EDIT);
//        this.workflowFacade.addVertex(wfvEdit2);
//        WorkflowVertex wfvView = WorkflowVertex.newVertex(200, 600, EmptyMethodClass.class.getName(), new BeanDouble(23.24), VertexDataBeanTypeEnum.VIEW );
//        this.workflowFacade.addVertex(wfvView);


//        WorkflowEdge wfe12 = WorkflowEdgeFactory.newDefault(
//                wfv1.selectVertexConnects().iterator().next(),
//                wfv2.selectVertexConnects().iterator().next());
//        this.workflowFacade.addEdge(wfe12);
//        WorkflowEdge wfe23 = WorkflowEdgeFactory.newDefault(
//                wfv2.selectVertexConnects().iterator().next(),
//                wfv3.selectVertexConnects().iterator().next());
//        this.workflowFacade.addEdge(wfe23);
//        WorkflowEdge wfe31 = WorkflowEdgeFactory.newDefault(
//                wfv3.selectVertexConnects().iterator().next(),
//                wfv1.selectVertexConnects().iterator().next());
//        this.workflowFacade.addEdge(wfe31);

    }

    public WorkflowFacade getWorkflowFacade() {
        return workflowFacade;
    }
}