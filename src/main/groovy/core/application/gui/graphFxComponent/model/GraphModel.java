package core.application.gui.graphFxComponent.model;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;

import java.util.HashSet;

public class GraphModel {
    private HashSet<OVertex> loadedVertexes = new HashSet<>();
    private HashSet<OEdge> loadedEdges = new HashSet<>();
    private HashSet<OVertex> newVertexes = new HashSet<>();
    private HashSet<OEdge> newEdges = new HashSet<>();
    private HashSet<OVertex> deletedVertexes = new HashSet<>();
    private HashSet<OEdge> deletedEdges = new HashSet<>();


    public GraphModel() {

    }

    //==================================================================================================================
    public HashSet<OVertex> getLoadedVertexes() {
        return loadedVertexes;
    }

    public HashSet<OEdge> getLoadedEdges() {
        return loadedEdges;
    }

    public HashSet<OVertex> getNewVertexes() {
        return newVertexes;
    }

    public HashSet<OEdge> getNewEdges() {
        return newEdges;
    }

    public HashSet<OVertex> getDeletedVertexes() {
        return deletedVertexes;
    }

    public HashSet<OEdge> getDeletedEdges() {
        return deletedEdges;
    }

    //=================================WORK WITH TEMP MAPPING GRAPH OF PART DB==========================================
    public void addLoadedVertex(OVertex v){
        this.loadedVertexes.add(v);
    }

    public void addLoadedEdge(OEdge e){
        this.loadedEdges.add(e);
    }

    public void addNewVertex(OVertex v){
        this.newVertexes.add(v);
    }

    public void addNewEdge(OEdge e){
        this.newEdges.add(e);
    }

    public void removeLoadedVertex(OVertex v){
        this.loadedVertexes.remove(v);
        this.deletedVertexes.add(v);
    }

    public void removeLoadedEdge(OEdge e){
        this.loadedEdges.remove(e);
        this.deletedEdges.add(e);
    }

    public void removeNewVertex(OVertex v){
        this.newVertexes.remove(v);
    }

    public void removeNewEdge(OEdge e){
        this.newEdges.remove(e);
    }

    //==================================================================================================================
    /**
     * merge all edges and vertexes from gModel into this graph
     * all loaded, new and deleted
     * @param gModel
     */
    public void merge(GraphModel gModel){
        // loaded
        this.loadedVertexes.addAll(gModel.getLoadedVertexes());
        this.loadedEdges.addAll(gModel.getLoadedEdges());
        // new
        this.newVertexes.addAll(gModel.getNewVertexes());
        this.newEdges.addAll(gModel.getNewEdges());
        // deleted
        this.deletedVertexes.addAll(gModel.getDeletedVertexes());
        this.deletedEdges.addAll(gModel.getDeletedEdges());
    }

    //==================================================================================================================
//    public OVertex newVDataChar(String ch){
//        OVertex v = this.vertexFactory.newVDataChar(ch);
//        this.addVertex(v);
//        return v;
//    }
//
//    public OVertex newVDataSound(){
//        OVertex v = this.vertexFactory.newVDataSound();
//        this.addVertex(v);
//        return v;
//    }
//
//    public OVertex newVDataVisual(){
//        OVertex v = this.vertexFactory.newVDataVisual();
//        this.addVertex(v);
//        return v;
//    }
//
//    public OVertex newVLink(){
//        OVertex v = this.vertexFactory.newVLink();
//        this.addVertex(v);
//        return v;
//    }
//
//    public OVertex newVParent(){
//        OVertex v = this.vertexFactory.newVParent();
//        this.addVertex(v);
//        return v;
//    }
//
//    //==================================================================================================================
//    public OEdge newELink(OVertex v1, OVertex v2){
//        OEdge e = this.edgeFactory.newELink(v1, v2);
//        this.addEdge(e);
//        return e;
//    }
//
//    public OEdge newEParent(OVertex v1, OVertex v2){
//        OEdge e = this.edgeFactory.newEParent(v1, v2);
//        this.addEdge(e);
//        return e;
//    }
//
//    public OEdge newEPrevNext(OVertex v1, OVertex v2){
//        OEdge e = this.edgeFactory.newEPrevNext(v1, v2);
//        this.addEdge(e);
//        return e;
//    }

}
