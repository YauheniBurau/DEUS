package core.old;

/**
 * very important class for comparison any types of clusters in any combinations
 */
public class CompareClusters {

//    /**
//     * compare by type,
//     * compare by sub clusters number
//     * compare by all prevs and nexts connections between clusters
//     * in the end tries to find 100% equality between ClusterSequence cl1 and ClusterSequence cl2
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static boolean byAll(ICluster cl1, ICluster cl2){
//        boolean result = false;
//        if( CompareClusters.byClusterClass(cl1, cl2)==false ){return false;}
//        if( CompareClusters.bySubClustersSize(cl1, cl2)==false ){return false;}
//        if( CompareClusters.byClusterStartSize(cl1, cl2)==false ){return false;}
//        if( CompareClusters.byClusterEndSize(cl1, cl2)==false ){return false;}
//        ClusterStart clS1 = Clusters.selectFirstClusterStart(cl1);
//        ClusterStart clS2 = Clusters.selectFirstClusterStart(cl2);
//
//        ClusterFIFO forCompare = new ClusterFIFO(); // contains clusters from cl1
//        ClusterFIFO compared = new ClusterFIFO();  // contains clusters from cl1
//        HashMap<ICluster, ICluster> map12 = new HashMap<>(); // contains equal pairs cl1 and cl2
//        // check that cl1 b cl2 are equal and create first pair for compare
//        if( CompareClusters.byClusterTypeAndClusterLinkValue(cl1, cl2) ){
//            map12.put(clS1, clS2);
//            forCompare.push(clS1);
//        }
//        // compare until "forCompare" is not empty
//        ICluster cl1Compare, cl2Compare;
//        HashMap<ICluster, ICluster> equals;
//        while(forCompare.size()>0){
//            cl1Compare = forCompare.pull();
//            cl2Compare = map12.get(cl1Compare);
//            equals = CompareClusters.findEqualPrevs(cl1Compare, cl2Compare);
//            for (ICluster e1: equals.keySet()) {
//                if( !compared.contains(e1) ){
//                    forCompare.push(e1);
//                    map12.put(e1, equals.get(e1));
//                }
//            }
//            equals = CompareClusters.findEqualNexts(cl1Compare, cl2Compare);
//            for (ICluster e1: equals.keySet()) {
//                if( !compared.contains(e1) ){
//                    forCompare.push(e1);
//                    map12.put(e1, equals.get(e1));
//                }
//            }
//            // add processed cluster into FIFO "compared"
//            compared.push(cl1Compare);
//        }
//        if( compared.size() == cl2.getSubClusters().size() ){result = true;}
//        return result;
//    }
//
//    /**
//     * universal method for comparison any types of clusters
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static boolean byClusterTypeAndClusterLinkValue(ICluster cl1, ICluster cl2){
//        boolean result = false;
//        if(CompareClusters.byClusterClass(cl1, cl2)){
//            result = true;
//        }
//        if( result==true && cl1.getClass()==ClusterLink.class && cl2.getClass()==ClusterLink.class ){
//            result = byClusterLinkValue( (ClusterLink) cl1, (ClusterLink) cl2 );
//        }
//        return result;
//    }
//
//    /**
//     * allows compare ClusterLink with ClusterLink. they are equal when both have the same cluster they link
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static boolean byClusterLinkValue(ICluster cl1, ICluster cl2) {
//        ClusterLink clL1;
//        ClusterLink clL2;
//        if (cl1.getClass() == ClusterLink.class && cl2.getClass() == ClusterLink.class) {
//            clL1 = (ClusterLink)cl1;
//            clL2 = (ClusterLink)cl2;
//            if (clL1.getCluster() == clL2.getCluster()) {
//                return true;
//            } else return false;
//        }
//        return false;
//    }
//
//
//    /**
//     * compare Clusters by Cluster Parent
//     * example: clusterLink 1 and clusterLink 2 are from the same clusterSequence
//     * @param clL1
//     * @param clL2
//     * @return
//     */
//    private static boolean byClusterParent(ICluster clL1, ICluster clL2){
//        if( clL1.getParent() == clL2.getParent() ){ return true; }
//        else return false;
//    }
//
//    /**
//     * compare Clusters by SubClusters size
//     * example: cluster 1 contain N subclusters and cluster 2 contains N subclusters
//     * @param clL1
//     * @param clL2
//     * @return
//     */
//    private static boolean bySubClustersSize(ICluster clL1, ICluster clL2){
//        if( clL1.getSubClusters().size() == clL2.getSubClusters().size() ){ return true; }
//        else return false;
//    }
//
//    /**
//     * compare Clusters by ClusterStart Number
//     * example:
//     * clusterSequence 1 contains 2 clusters of type ClusterStart
//     * and
//     * clusterSequence 2 contains 2 clusters of type ClusterStart
//     * @param clL1
//     * @param clL2
//     * @return
//     */
//    private static boolean byClusterStartSize(ICluster clL1, ICluster clL2){
//        int N1 = 0, N2 = 0;
//        for (ICluster cl: clL1.getSubClusters()) {
//            if(cl.getClass() == ClusterStart.class){
//                N1+=1;
//            }
//        }
//        for (ICluster cl: clL2.getSubClusters()) {
//            if(cl.getClass() == ClusterStart.class){
//                N2+=1;
//            }
//        }
//        if( N1==N2 ){ return true; }
//        else return false;
//    }
//
//    /**
//     * compare Clusters by ClusterEnd Number
//     * example:
//     * clusterSequence 1 contains 2 clusters of type ClusterEnd
//     * and
//     * clusterSequence 2 contains 2 clusters of type ClusterEnd
//     * @param clL1
//     * @param clL2
//     * @return
//     */
//    private static boolean byClusterEndSize(ICluster clL1, ICluster clL2){
//        int N1 = 0, N2 = 0;
//        for (ICluster cl: clL1.getSubClusters()) {
//            if(cl.getClass() == ClusterEnd.class){
//                N1+=1;
//            }
//        }
//        for (ICluster cl: clL2.getSubClusters()) {
//            if(cl.getClass() == ClusterEnd.class){
//                N2+=1;
//            }
//        }
//        if( N1==N2 ){ return true; }
//        else return false;
//    }
//
//    /**
//     * compare inputs of two clusters and try to find pairs of the same nexts clusters
//     * cl1 and cl2 can be unequal, because the comparison is for nexts connected clusters
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static HashMap<ICluster, ICluster> findEqualNexts(ICluster cl1, ICluster cl2){
//        HashSet<ICluster> cl1Nexts = cl1.getNexts();
//        HashSet<ICluster> cl2Nexts = cl2.getNexts();
//        HashMap<ICluster, ICluster> equals = new HashMap<>();
//        for (ICluster cl1N: cl1Nexts) {
//            for (ICluster cl2N: cl2Nexts) {
//                if( CompareClusters.byClusterTypeAndClusterLinkValue(cl1N, cl2N) ){
//                    equals.put(cl1N, cl2N);
//                }
//            }
//        }
//        return equals;
//    }
//
//    /**
//     * compare inputs of two clusters and try to find pairs of the same previous clusters
//     * cl1 and cl2 can be unequal, because the comparison is for previous connected clusters
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static HashMap<ICluster, ICluster> findEqualPrevs(ICluster cl1, ICluster cl2){
//        HashSet<ICluster> cl1Prevs = cl1.getPrevs();
//        HashSet<ICluster> cl2Prevs = cl2.getPrevs();
//        HashMap<ICluster, ICluster> equals = new HashMap<>();
//        for (ICluster cl1N: cl1Prevs) {
//            for (ICluster cl2N: cl2Prevs) {
//                if( CompareClusters.byClusterTypeAndClusterLinkValue(cl1N, cl2N) ){
//                    equals.put(cl1N, cl2N);
//                }
//            }
//        }
//        return equals;
//    }
//

}