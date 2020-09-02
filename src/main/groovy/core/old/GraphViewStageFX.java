package core.old;

//public class GraphViewStageFX extends StageFX {

//    /**
//     * eventHandler for hProcessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hProcessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadProcessWorkflowFX t = new ThreadProcessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };

//    /**
//     * eventHandler for hUnprocessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hUnprocessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//                this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadUnprocessWorkflowFX t = new ThreadUnprocessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };
