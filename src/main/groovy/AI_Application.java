/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.StageController;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.*;
import newWorkflowFx.WorkflowIO;
import newWorkflowFx.ShapeSvgPathEnum;
import core.application.gui.workflowFxComponent.view.Workflow2dFxStage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.DefaultContextLoader;

public class AI_Application extends Application {

    @Override
    public void start(Stage stage) {
        // ===========================================================
        JarClassLoader jcl = new JarClassLoader();
        //jcl.add("myjarlib/");
        DefaultContextLoader context=new DefaultContextLoader(jcl);
        context.loadContext();
        // ============================================================

        StageFxBuilder stg = new StageFxBuilder(stage);
        // ======================================= create main scene ===================================================
        BorderPane root = BorderPaneFxFactory.create();
        Scene scene = SceneFxFactory.create(root, 1366, 768);
        MenuBar menuBar = MenuBarFxFactory.createApplicationStageMenuBar();
        root.setTop(menuBar);
        stg.withTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stg.withScene(scene);
        // ============= add test button into main window with event to open core.old.graph visualization window =======
        Button btnTest = ButtonFxFactory.create(
                "testBtn",
                e-> { }
        );
        Button btnOpenWorkflowStage = ButtonFxFactory.create(
                "btnOpenWorkflowStage",
                e-> { Workflow2dFxStage workflowStage = new Workflow2dFxStage(stage, new WorkflowIO());
                    StageController.showStage(workflowStage);}
        );
        Button btnOpenWFStage = ButtonFxFactory.create(
                "btnTest Workflow lib",
                e-> { Workflow2dFxStage workflowStage = new Workflow2dFxStage(stage, new WorkflowIO());
                    StageController.showStage(workflowStage);}
        );

        // =============================================================================================================
        SVGPath path;

        HBox hb = new HBox();
        hb.setMaxSize(300, 100);
        hb.setMinSize(300, 100);

        Label lab = new Label("Name of Node");

        Button closeBtn = ButtonFxFactory.create("X", e->{});
        path = new SVGPath();
        path.setContent(ShapeSvgPathEnum.OVAL.value());
        closeBtn.setShape(path);
        closeBtn.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );

        Button codeBtn = ButtonFxFactory.create("C", e->{});
        path = new SVGPath();
        path.setContent(ShapeSvgPathEnum.OVAL.value());
        codeBtn.setShape(path);
        codeBtn.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );

        hb.getChildren().addAll(lab, codeBtn, closeBtn);

        ImageView iv = ImageViewFxFactory.create(100,300);
        TitledPane tpane = new TitledPane("Size", iv);
        // =============================================================================================================
        Pane hbPane = new Pane(hb);
        hbPane.setMaxSize(300, 100);
        hbPane.setMinSize(300, 100);
        path = new SVGPath();
        path.setContent(ShapeSvgPathEnum.ROUNDED_RECTANGLE.value());
        hbPane.setShape(path);
        hbPane.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );

        StackPane stkpane = new StackPane();
        stkpane.getChildren().add(tpane);
        stkpane.setAlignment(tpane, Pos.TOP_CENTER);
        stkpane.getChildren().add(hb);
        stkpane.setAlignment(hb, Pos.TOP_CENTER);

        VBox centerVBox = new VBox(btnTest, btnOpenWorkflowStage, stkpane);


        root.setCenter(centerVBox);

        // =============================================================================================================
        stage.setOnCloseRequest(e-> {});
        stg.show();
    }

    static void main(String[] args) {
        launch(args);
    }

}

// TODO: remove later

// ApplicationControllers.showNodesPalleteStageFX();
// scene.getStylesheets().add(getClass().getResource("core.application.AI_Application.css").getFile() );
// scene.getStylesheets().add(getClass().getResource("core.application.AI_Application.css").toExternalForm() );
