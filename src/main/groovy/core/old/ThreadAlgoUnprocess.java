package core.old;

public class ThreadAlgoUnprocess extends Thread {
//    private AbstractAlgorithm algorithm;
//
//    public ThreadAlgoUnprocess(AbstractAlgorithm algo) {
//        this.algorithm = algo;
//    }
//
//    @Override
//    public void run() {
////        Logger log = algorithm.getNode().getWorkflow().getLogger();
////        log.info("algo: " + algorithm.getNode().getName() + " : " + "UNPROCESS started\n");
//        LinkedList<Data> inputs = this.algorithm.getInputs();
//        for (Data input: inputs) {
//            if(input.getConnections().size()==1){
//                ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(input.getConnection(0).getStart().getAlgorithm());
////                log.info("starting algo: " + input.getConnection(0).getStart().getAlgorithm().getName());
//                t.start();
//                try {
//                    t.join();
//                } catch (InterruptedException e) {
//                    algorithm.setState(AlgorithmStateEnum.EXCEPTION);
////                    log.info("algo: " + algorithm.getNode().getName() + " : " + "UNPROCESS exception.\n" + e.getMessage() + "\n");
//                    //e.printStackTrace();
//                }
//            }
//        }
//        algorithm.setState(AlgorithmStateEnum.NOT_PROCESSED);
////        log.info("algo: " + algorithm.getNode().getName() + " : " + "UNPROCESS finished\n");
//    }
//
}
