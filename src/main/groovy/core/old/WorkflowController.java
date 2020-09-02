package core.old;

/**
 * change model or run processes for change model,
 * and after that, make changes in GUI view
 */
//public class WorkflowController {
//
//
//
//    /**
//     * open dialog of changeing size of workflow canvas
//     * if ok then change model and view
//     */
//    public static void showEditCanvasSizeDialog(WorkflowFX workflowFX){
////        // TODO: use something more compact for creating form controlsFX
////        ParamDoubleFX fieldSizeX;
////        ParamDoubleFX fieldSizeY;
////        GridPane root = new GridPane();
////        StageFX stg = new StageFX()
////            .withModality(Modality.WINDOW_MODAL)
////            .withOwner(workflowFX.getStage())
////            .withTitle("Change size of workflow canvas")
////            .withScene(root, 240, 320)
////            .withInitStyle(StageStyle.UTILITY)
////            .withAlwaysOnTop(true);
////        fieldSizeX = new ParamDoubleFX( new Param<Double>("SizeX:", workflowFX.getMinWidth(), ParamDoubleFX.class) );
////        fieldSizeY = new ParamDoubleFX( new Param<Double>("SizeY:", workflowFX.getMinHeight(), ParamDoubleFX.class) );
////        ButtonFxBuilder btnOk = new ButtonFxBuilder().withText("Ok").withOnAction(e->{
////            fieldSizeX.updateToModel();
////            fieldSizeY.updateToModel();
////            WorkflowController.changeWorkflowSize(workflowFX, fieldSizeX.getParam().getValue(), fieldSizeY.getParam().getValue());
////            stg.close();
////        });
////        Button btnCancel = new ButtonFxBuilder().withText("Cancel").withOnAction(e->{stg.close();});
////        root.add(fieldSizeX, 0, 0,2, 1);
////        root.add(fieldSizeY, 0, 1,2, 1);
////        root.add(btnOk, 0, 2,1, 1);
////        root.add(btnCancel, 1, 2,1, 1);
////        stg.show();
//    }

//
//    /**
//     * add Connection to view and model
//     * @param workflowStageFX
//     * @param connectionFX
//     */
//    public static void addConnection(WorkflowStageFX workflowStageFX, ConnectionFX connectionFX){
//        workflowStageFX.getWorkflowFX().addConnectionFX(connectionFX);
//        Connection connection = new Connection(connectionFX.getStart().getValue(), connectionFX.getEnd().getValue());
//        workflowStageFX.getWorkflowFX().getWorkflow().addConnection(connection);
//    }
//
//}
