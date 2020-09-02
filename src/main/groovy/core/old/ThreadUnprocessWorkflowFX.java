package core.old;

public class ThreadUnprocessWorkflowFX extends Thread {
//    private NodeFX nodeFX;
//
//    public ThreadUnprocessWorkflowFX(NodeFX nodeFX) {
//        this.nodeFX = nodeFX;
//    }
//
//    @Override
//    public void run() {
//        Logger log = nodeFX.getWorkflowFX().getWorkflow().getLogger();
//        log.info("workflowModel process started for end Node: " + this.getName() + "\n");
//        ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(this.nodeFX.getNode().getAlgorithm());
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            // TODO: add here get data and put into workflowFX
//            System.out.println("exception in workflowModel init process: " + nodeFX.getNode().getName() + " : " + e.getMessage() + "\n");
//            e.printStackTrace();
//        }
//        // wait until join sub threads count all algorithms
//        // change colors of nodes
//        ArrayList<NodeFX> nodesFX = this.nodeFX.getWorkflowFX().getNodesFX();
//        for (NodeFX nodeFX: nodesFX) {
//            nodeFX.updateState();
//        }
//        log.info("workflowModel process finished for end Node: " + this.getName() + "\n");
//    }
}
