package core.old;

public class ThreadProcessWorkflowFX extends Thread {
//    private NodeFX nodeFX;
//
//    public ThreadProcessWorkflowFX(NodeFX nodeFX) {
//        this.nodeFX = nodeFX;
//    }
//
//    @Override
//    public void run() {
//        Logger log = nodeFX.getWorkflowFX().getWorkflow().getLogger();
//        log.info("workflowModel process started for end Node: " + this.getName() + "\n");
//        ThreadAlgoProcess t = new ThreadAlgoProcess(this.nodeFX.getNode().getAlgorithm());
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            System.out.println("exception in workflowModel init process: " + nodeFX.getNode().getName() + " : " + e.getMessage() + "\n");
//            e.printStackTrace();
//        }
//        // wait until join sub threads count all algorithms
//        // change colors of every changed NodeFX
//        ArrayList<NodeFX> nodesFX = this.nodeFX.getWorkflowFX().getNodesFX();
//        for (NodeFX nodeFX: nodesFX) {
//            nodeFX.updateState();
//        }
//        log.info("workflowModel process finished for end Node: " + this.getName() + "\n");
//    }
//
}
