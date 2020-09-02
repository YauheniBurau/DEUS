package core.old;

/**
 * very important that all clusters in cl1 and cl2 are ClusterLink
 */
public class SearchPatterns {

//    /**
//     * that two clusters are from two trees
//     * and by value that clusters are equal
//     * so that function treis to find crossed subtree equal for cl1.Parent and cl2.Parent in that cross point of
//     * clusters cl1 and cl2
//     * @param cl1
//     * @param cl2
//     * @return
//     */
//    public static ClusterSequence byIntersection(ICluster cl1, ICluster cl2) {
//        ClusterFIFO forCompare = new ClusterFIFO(); // contains clusters from cl1
//        ClusterFIFO compared = new ClusterFIFO();  // contains clusters from cl1
//        HashMap<ICluster, ICluster> map12 = new HashMap<>(); // contains equal pairs cl1 and cl2
//        HashMap<ICluster, ICluster> map13 = new HashMap<>(); // contains equal pairs cl1 and cl3
//        // check that cl1 b cl2 are equal and create first pair for compare
//        if( CompareClusters.byClusterTypeAndClusterLinkValue(cl1, cl2) ){
//            map12.put(cl1, cl2);
//            forCompare.push(cl1);
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
//        // convert "compared" into ClusterSequence
//        // 1. create all new clusters copy for every key cluster in "Compared"
//        ClusterSequence clSeq = new ClusterSequence();
//        forCompare = new ClusterFIFO();
//        ClusterLink clOrigin, clCopy;
//        while(compared.size()>0) {
//            clOrigin = (ClusterLink) compared.pull();
//            clCopy = clOrigin.getCluster().createClusterLink();
//            forCompare.push(clOrigin);
//            map13.put(clOrigin, clCopy);
//            // add all clusters copies into copy ClusterSequence
//            clSeq.addSubCluster(clCopy);
//        }
//        // 2. pass through all key clusters from Compared and create all copy connection for copy clusters
//        ICluster cl, clCopyCurr, clCopyPrev, clCopyNext;
//        while(forCompare.size()>0){
//            cl = forCompare.pull();
//            for (ICluster clPrev: cl.getPrevs() ) {
//                if(forCompare.contains(clPrev)){
//                    clCopyCurr = map13.get(cl);
//                    clCopyPrev = map13.get(clPrev);
//                    Clusters.connect(clCopyPrev, clCopyCurr);
//                }
//            }
//            for (ICluster clNext: cl.getNexts() ) {
//                if(forCompare.contains(clNext)){
//                    clCopyCurr = map13.get(cl);
//                    clCopyNext = map13.get(clNext);
//                    Clusters.connect(clCopyCurr, clCopyNext);
//                }
//            }
//        }
//        // 3. add all possible ClusterStart and ClusterEnd for copy
//        Clusters.closeByClusterStartAndClusterEnd(clSeq);
//        return clSeq;
//    }
//
//    /**
//     * usually FIFO intersectionClusters - is set formed by looking for ClusterLinks, that links to the same cluster
//     * so it mean that cluster and their prevs and nexts clusters can be intersected
//     * @param intersectionClusters set of clusters which have to be checked as do they have intersections between each
//     *                             other
//     * @return FIFO of clusterSequence (cluster patterns)
//     */
//    public static ClusterFIFO byIntersection(ClusterFIFO intersectionClusters) {
//        ICluster cl1, clPattern;
//        boolean match = false;
//        ClusterFIFO intersections = new ClusterFIFO();
//        ClusterFIFO cIntersectionClusters = intersectionClusters.copy();
//        while(cIntersectionClusters.size()>0){
//            cl1 = cIntersectionClusters.pull();
//            for(ICluster cl2: cIntersectionClusters){
//                clPattern = SearchPatterns.byIntersection(cl1, cl2);
//                if (clPattern!=null && clPattern.getSubClusters().size()>3){
//                    // перед тем как добавлять в intersections, проверить что такого уникального кластера-последовательности нет
//                    intersections.push(clPattern);
//                }
//            }
//        }
//        return intersections;
//    }


}