
import core.application.controller.StageController;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.ButtonFxFactory;
import core.application.gui.factoryFx.PaneFxFactory;
import core.application.gui.factoryFx.SceneFxFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import newWorkflowFx.WorkflowFxStage;

public class AI_Test extends Application {

    @Override
    public void start(Stage stage) {

        StageFxBuilder stg = new StageFxBuilder(stage);
        // ======================================= create main scene ===================================================
        Pane root = PaneFxFactory.create();
        Scene scene = SceneFxFactory.create(root, 1366, 768);
        stg.withTitle("As Kon - DEUS(Data Explorer unified System");
        stg.withScene(scene);
        Button btnOpenWorkflowStage = ButtonFxFactory.create(
                "btnOpenWorkflowStage",
                e-> { WorkflowFxStage workflowStage = new WorkflowFxStage(stage);
                    StageController.showStage(workflowStage);}
        );
        root.getChildren().add(btnOpenWorkflowStage);
        // =============================================================================================================
        stage.setOnCloseRequest(e-> {});
        stg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
