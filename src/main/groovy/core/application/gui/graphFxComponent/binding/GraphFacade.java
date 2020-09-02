package core.application.gui.graphFxComponent.binding;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import core.application.gui.graphFxComponent.model.GraphModel;
import core.application.gui.graphFxComponent.odb.GraphDb;
import core.application.gui.graphFxComponent.view.*;

import java.util.HashMap;
import java.util.Set;

/**
 * every method hs prefix db... m... fx... it means that that method makes changes in that Graph
 * also possible methods db_m_... e.t.c. it means changes in GraphDb and GraphModel instantly
 * also possible methods db_m_fx_... e.t.c. it means changes in GraphDb and GraphModel and GraphFx instantly
 */
public class GraphFacade {
    private Graph2dFx graph2dFx;
    private GraphModel graphModel;
    private GraphDb graphDb;
    private HashMap<OVertex, Vertex2dFx> vertexMapping = new HashMap<>(); // graphModel -> graphFx mapping
    private HashMap<OEdge, Edge2dFx> edgeMapping = new HashMap<>(); // graphModel -> graphFx mapping
    private boolean isMappingFxOn = false;
    private boolean isMappingModelOn = false;
    private boolean isMappingDbOn = false;

    public GraphFacade(Graph2dFx graph2dFx, GraphModel graphModel, GraphDb graphDb) {
        this.graph2dFx = graph2dFx;
        this.graphModel = graphModel;
        this.graphDb = graphDb;
    }

    public void fx_mapGraphModelIntoGraph2dFx() {
        Set<OVertex> vSet = graphModel.getLoadedVertexes();
        vSet.addAll(graphModel.getNewVertexes());
        Set<OEdge> eSet = graphModel.getLoadedEdges();
        eSet.addAll(graphModel.getNewEdges());
        Vertex2dFx vFx, v1Fx, v2Fx;
        Edge2dFx eFx;
        // mapping of vertexes
        for (OVertex v : vSet) {
            vFx = Vertex2dFxFactory.mapVertex2dFx(v);
            vertexMapping.put(v, vFx);
            graph2dFx.addVertex(vFx);
        }
        // mapping of edges
        for (OEdge e : eSet) {
            v1Fx = vertexMapping.get(e.getFrom());
            v2Fx = vertexMapping.get(e.getTo());
            eFx = Edge2dFxFactory.mapEdge2dFx(v1Fx, v2Fx, e);
            edgeMapping.put(e, eFx);
            graph2dFx.addEdge(eFx);
        }
    }

    public void fx_orderVertexes2dFxInSphere(int sphereRadius) {
        this.graph2dFx.orderVertexesInSphere(sphereRadius);
    }

    public OVertex db_strToGraphDb(String s) {
        return this.graphDb.strToGraph(s);
    }

    public GraphModel db_selectAllChildrenWithParent(OVertex vParent) {
        return graphDb.selectAllChildrenWithParent(vParent);
    }

    public void setGraph2dFx(Graph2dFx graph2dFx) {
        this.graph2dFx = graph2dFx;
    }

    public void setGraphModel(GraphModel graphModel) {
        this.graphModel = graphModel;
    }

    public void setGraphDb(GraphDb graphDb) {
        this.graphDb = graphDb;
    }

    /**
     * if MappingFxOn == true
     * then all changes in Graph2dFx will be applied instantly into GraphModel
     *
     * @param mappingOn
     */
    public void setMappingFxOn(boolean mappingOn) {
        this.isMappingFxOn = mappingOn;
    }

    /**
     * if MappingModelOn == true
     * then all changes in GraphModel will be applied instantly into Graph2dFx and GraphDb
     *
     * @param mappingOn
     */
    public void setMappingModelOn(boolean mappingOn) {
        this.isMappingModelOn = mappingOn;
    }

    /**
     * if MappingDbOn == true
     * then all changes in GraphDb will be applied instantly into GraphModel
     *
     * @param mappingOn
     */
    public void setMappingDbOn(boolean mappingOn) {
        this.isMappingDbOn = mappingOn;
    }

    /**
     * push into db all changes are made with loadedVertexes and LoadedEdges
     * clear sets of newEdges, newVertexes, deletedEdges, deletedVertexes
     */
    public void m_db_pushLoaded() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * push into db all changes are made with newVertexes and newEdges
     * move all sets of newEdges, newVertexes into LoadedEdges, LoadedVertexes
     */
    public void m_db_pushNew() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * push into db all changes are made with deletedVertexes and deletedEdges
     * clear sets of deletedVertexes and deletedEdges
     */
    public void m_db_pushDeleted() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * reload all vertexes from loadedVertexes and reload all edges, connection between all that vertexes
     * if Edge or Vertex already removed from db, then remove them from loadedVertexes and loadedEdges
     */
    public void m_pull() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * clear graphModel for working with new set of downloaded or new created Vertexes and Edges
     * don't make any push changes into DB even Graph Model contains changes
     */
    public void m_clear() {
        this.graphModel.getLoadedVertexes().clear();
        this.graphModel.getLoadedEdges().clear();
        this.graphModel.getNewVertexes().clear();
        this.graphModel.getNewEdges().clear();
        this.graphModel.getDeletedVertexes().clear();
        this.graphModel.getDeletedEdges().clear();
        clearMapping();
    }

    /**
     * merge current GraphModel with 'm'
     * @param m
     */
    public void m_merge(GraphModel m){
        this.graphModel.merge(m);
    }

    /**
     * clear only graph2dFx for working with new set of downloaded or new created Vertexes and Edges
     * don't make any push changes into DB even Graph Model contains changes
     */
    public void fx_clear() {
        this.graph2dFx.clear();
        clearMapping();
    }

    private void clearMapping() {
        this.vertexMapping.clear();
        this.edgeMapping.clear();
    }

}


    //==================================================================================================================
//    public OVertex newVDataChar(String ch){
//        OVertex oV = graphModel.newVDataChar(ch);
//        if(this.isMappingOn){
//            Vertex2dFx fxV = graph2dFx.newVDataChar(ch);
//            vertexMapping.put(oV, fxV);
//        }
//        return oV;
//    }
//
//    public OVertex newVDataSound(){
//        OVertex oV = graphModel.newVDataSound();
//        if(this.isMappingOn){
//            Vertex2dFx fxV = graph2dFx.newVDataSound();
//            vertexMapping.put(oV, fxV);
//        }
//        return oV;
//    }
//
//    public OVertex newVDataVisual(){
//        OVertex oV = graphModel.newVDataVisual();
//        if(this.isMappingOn){
//            Vertex2dFx fxV = graph2dFx.newVDataVisual();
//            vertexMapping.put(oV, fxV);
//        }
//        return oV;
//    }
//
//    public OVertex newVLink(){
//        OVertex oV = graphModel.newVLink();
//        if(this.isMappingOn){
//            Vertex2dFx fxV = graph2dFx.newVLink();
//            vertexMapping.put(oV, fxV);
//        }
//        return oV;
//    }
//
//    public OVertex newVParent(){
//        OVertex oV = graphModel.newVParent();
//        if(this.isMappingOn){
//            Vertex2dFx fxV = graph2dFx.newVParent();
//            vertexMapping.put(oV, fxV);
//        }
//        return oV;
//    }
//
    //==================================================================================================================
//    public OEdge newELink(OVertex v1, OVertex v2){
//        OEdge oE = graphModel.newELink(v1, v2);
//        Vertex2dFx fxV1, fxV2;
//        if(this.isMappingOn){
//            fxV1 = vertexMapping.get(v1);
//            fxV2 = vertexMapping.get(v2);
//            Edge2dFx fxE = graph2dFx.newELink(fxV1, fxV2);
//            edgeMapping.put(oE, fxE);
//        }
//        return oE;
//    }
//
//    public OEdge newEParent(OVertex v1, OVertex v2){
//        OEdge oE = graphModel.newEParent(v1, v2);
//        Vertex2dFx fxV1, fxV2;
//        if(this.isMappingOn){
//            fxV1 = vertexMapping.get(v1);
//            fxV2 = vertexMapping.get(v2);
//            Edge2dFx fxE = graph2dFx.newEParent(fxV1, fxV2);
//            edgeMapping.put(oE, fxE);
//        }
//        return oE;
//    }
//
//    public OEdge newEPrevNext(OVertex v1, OVertex v2){
//        OEdge oE = graphModel.newEPrevNext(v1, v2);
//        Vertex2dFx fxV1, fxV2;
//        if(this.isMappingOn){
//            fxV1 = vertexMapping.get(v1);
//            fxV2 = vertexMapping.get(v2);
//            Edge2dFx fxE = graph2dFx.newEPrevNext(fxV1, fxV2);
//            edgeMapping.put(oE, fxE);
//        }
//        return oE;
//    }

    //==================================================================================================================
//    public void generate(int vertexesNumber, int edgesNumber){
//        int n;
//        Vertex2dFx stV, enV;
//        Edge2dFx e;
//        // VERTEXES
//        for (n = 0; n < vertexesNumber; n++) {
//            this.addVertex(Vertex2dFxFactory.newVDataChar(RandomStringUtils.random(1, true, false) ));
//        }
//        // EDGES
//        int start, end;
//        Object[] vertexes = this.graph.vertexSet().toArray();
//        for (n = 0; n < edgesNumber; n++) {
//            start = (int)Math.round(Math.random()*(vertexesNumber-1));
//            end = (int)Math.round(Math.random()*(vertexesNumber-1));
//            if(start!=end) {
//                stV = (Vertex2dFx) vertexes[start];
//                enV = (Vertex2dFx) vertexes[end];
//                e = Edge2dFxFactory.newEPrevNext(stV, enV);
//                this.addEdge(stV, enV, e);
//            }else{
//                // add cycle edge where start and end vertex are the same
//            }
//        }
//    }

//ListenableGraph listenableGraph;;
//this.listenableGraph = new DefaultListenableGraph(this.graphDb.getJGraphT());
//this.setGraphListener();
//public void setGraphListener(){
//        this.listenableGraph.addGraphListener(new GraphListener() {
//@Override
//public void edgeAdded(GraphEdgeChangeEvent graphEdgeChangeEvent) {
//
//        }
//
//@Override
//public void edgeRemoved(GraphEdgeChangeEvent graphEdgeChangeEvent) {
//
//        }
//
//@Override
//public void vertexAdded(GraphVertexChangeEvent graphVertexChangeEvent) {
//
//        }
//
//@Override
//public void vertexRemoved(GraphVertexChangeEvent graphVertexChangeEvent) {
//
//        }
//        });
//        }


    //==================================================================================================================
//    public Vertex2dFx newVDataChar(String ch){
//        Vertex2dFx v = Vertex2dFxFactory.newVDataChar(ch);
//        this.addVertex(v);
//        return v;
//    }
//
//    public Vertex2dFx newVDataSound(){
//        Vertex2dFx v = Vertex2dFxFactory.newVDataSound();
//        this.addVertex(v);
//        return v;
//    }
//
//    public Vertex2dFx newVDataVisual(){
//        Vertex2dFx v = Vertex2dFxFactory.newVDataVisual();
//        this.addVertex(v);
//        return v;
//    }
//
//    public Vertex2dFx newVLink(){
//        Vertex2dFx v = Vertex2dFxFactory.newVLink();
//        this.addVertex(v);
//        return v;
//    }
//
//    public Vertex2dFx newVParent(){
//        Vertex2dFx v = Vertex2dFxFactory.newVParent();
//        this.addVertex(v);
//        return v;
//    }
//
//    //==================================================================================================================
//    public Edge2dFx newELink(Vertex2dFx v1, Vertex2dFx v2){
//        Edge2dFx e = Edge2dFxFactory.newELink(v1, v2);
//        this.addEdge(v1, v2, e);
//        return e;
//    }
//
//    public Edge2dFx newEParent(Vertex2dFx v1, Vertex2dFx v2){
//        Edge2dFx e = Edge2dFxFactory.newEParent(v1, v2);
//        this.addEdge(v1, v2, e);
//        return e;
//    }
//
//    public Edge2dFx newEPrevNext(Vertex2dFx v1, Vertex2dFx v2){
//        Edge2dFx e = Edge2dFxFactory.newEPrevNext(v1, v2);
//        this.addEdge(v1, v2, e);
//        return e;
//    }
