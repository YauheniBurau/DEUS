package core.application.gui.factoryFx;

import core.application.controller.StageController;
import core.application.gui.builderFx.MenuBarFxBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import newGui.NotificationsFxFactory;

public class MenuBarFxFactory {

    public static MenuBar createApplicationStageMenuBar(){
        // =========================================== GUI MENU BAR ====================================================
        Stage stgUtilit1 = StageFxFactory.createUtilityStage1FX(null);
        Stage stgUtilit2 = StageFxFactory.createUtilityStage2FX(null);

        MenuBarFxBuilder menuBar = new MenuBarFxBuilder();

        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> {
            NotificationsFxFactory.showNotImplemented();});
        menuBar.withMenuItem("Open", fileMenu, e -> {NotificationsFxFactory.showNotImplemented();});
        menuBar.withMenuItem("Save", fileMenu, e -> {NotificationsFxFactory.showNotImplemented();});
        menuBar.withMenuItem("Save As...", fileMenu, e -> {NotificationsFxFactory.showNotImplemented();});
        menuBar.withMenuItem("Exit", fileMenu, e -> {NotificationsFxFactory.showNotImplemented();});

        menuBar.withMenuItem("Copy", editMenu, e-> {NotificationsFxFactory.showNotImplemented();} );
        menuBar.withMenuItem("Paste", editMenu, e -> {NotificationsFxFactory.showNotImplemented();} );

        menuBar.withMenuItem("Utility1", toolsMenu, e -> StageController.showStage(stgUtilit1) );
        menuBar.withMenuItem("Utility2", toolsMenu, e -> StageController.showStage(stgUtilit2) );
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> {});

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> {NotificationsFxFactory.showNotImplemented();});

        menuBar.withMenuItem("Help", helpMenu, e -> {NotificationsFxFactory.showNotImplemented();});
        menuBar.withMenuItem("About", helpMenu, e -> {NotificationsFxFactory.showNotImplemented();});

        return menuBar.build();
    }


}

// TODO: remove later

//    /**
//     * EventHandler for menu File.Save OnAction - open dialog for choose file where to save scheme workflowModel
//     */
//    public static void saveActiveWorkflowStageFX() {
//        // TODO:
//        WorkflowStageFX stg = app.getActiveWorkflowStageFX();
//        WorkflowController.saveWorkflow(stg, stg.getFile());
//    }

//    /**
//     * show that dialog if File.Exit chosen in Main Menubar
//     */
//    public static void showApplicationExitDialog(){
//        // TODO:
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Close Application dialog");
//        alert.setHeaderText("It will close application with all opened windows, without any saves");
//        alert.setContentText("You can't discard that changes. Are you sure?");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            app.getApplicationStage().close();
//        }
//    }

//    /**
//     * show that dialog if Help.Help chosen in Main Menubar
//     */
//    public static void showAppHelpDialog(){
//        // TODO:
//        StageFX stg = new StageFX();
//        Pane root = new Pane();
//        root.setPadding(new Insets(10));
//        // scene init
//        stg.withScene(root, 640, 480).withTitle("Help")
//                .withInitStyle(StageStyle.DECORATED)
//                .withOwner(app.getApplicationStage());
//        stg.show();
//    }

//    /**
//     * show that dialog if Help.About chosen in Main Menubar
//     */
//    public static void showAppAboutDialog() {
//        // TODO:
//        Label info = new Label("GIAS - Global Intellectual Artificial System.\n" +
//                "Copyright \u00a9 2017-2019. As Kon \n");
//        HBox box = new HBox(info);
//        box.setAlignment(Pos.CENTER);
//        StageFX stg = new StageFX();
//        Pane root = new Pane();
//        root.setPadding(new Insets(10));
//        root.getChildren().add(box);
//        // scene init
//        stg.withScene(root, 320, 160).withTitle("About")
//                .withInitStyle(StageStyle.DECORATED)
//                .withOwner(app.getApplicationStage());
//        stg.show();
//    }
