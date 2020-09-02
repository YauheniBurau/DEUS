package newWorkflowFx

import core.application.controller.StageController
import core.application.gui.builderFx.StageFxBuilder
import core.application.gui.factoryFx.SceneFxFactory
import core.application.gui.zoomDrugScrollFxComponent.ZoomDrugScrollFx
import core.old.TypeToType
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle

/**
 * refactored to new version 31.08.2020
 */
class WorkflowFxStage extends Stage {
    WorkflowFx workflowFx = new WorkflowFx()

    WorkflowFxStage(Stage owner) {
        ZoomDrugScrollFx scrollPane = new ZoomDrugScrollFx(this.workflowFx);
        StageFxBuilder stg = new StageFxBuilder(this)
        Scene scene = SceneFxFactory.create(scrollPane, 1024, 640);
        stg.withScene(scene).withTitle("Workflow")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    void initialize(){
        this.workflowFx.setMinSize(2000, 1500)
        WVertexFx v1 = WVertexFx.create(300, 300, TypeToType.class)
        this.workflowFx.getChildren().add(v1)

        this.workflowFx.setMinSize(2000, 1500)
        WVertexFx v2 = WVertexFx.create(600, 300, new TypeToType() )
        this.workflowFx.getChildren().add(v2)
    }

}