package core.old;

public class ThreadAlgoProcess extends Thread {
//    private AbstractAlgorithm algorithm;
//
//    public ThreadAlgoProcess(AbstractAlgorithm algo) {
//        this.algorithm = algo;
//    }
//
//    @Override
//    public void run() {
////        Logger log = algorithm.getNode().getWorkflow().getLogger();
////        log.info("algo: " + algorithm.getNode().getName() + " : " + "PROCESS started\n");
//        if(algorithm.getState() != AlgorithmStateEnum.SUCCESS){
//            LinkedList<Data> inputs = this.algorithm.getInputs();
//            for (Data input: inputs) {
//                if(input.getConnections().size()==1){
//                    ThreadAlgoProcess t = new ThreadAlgoProcess(input.getConnection(0).getStart().getAlgorithm());
//                    t.start();
//                    try {
//                        t.join();
//                    } catch (InterruptedException e) {
//                        algorithm.setState(AlgorithmStateEnum.EXCEPTION);
////                        log.info("algo: " + algorithm.getNode().getName() + " : " + "PROCESS exception.\n" + e.getMessage() + "\n");
//                        //e.printStackTrace();
//                    }
//                }
//            }
//            Boolean result = algorithm.onProcess();
//            if(result == true){
//                algorithm.setState(AlgorithmStateEnum.SUCCESS);
////                log.info("algo: " + algorithm.getNode().getName() + " : " + "PROCESS finished\n");
//            }else {
//                algorithm.setState(AlgorithmStateEnum.FAIL);
////                log.info("algo: " + algorithm.getNode().getName() + " : " + "PROCESS fail\n");
//            }
//        }
//    }

}
