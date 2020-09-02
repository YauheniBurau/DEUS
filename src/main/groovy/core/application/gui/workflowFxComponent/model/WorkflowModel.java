package core.application.gui.workflowFxComponent.model;

import java.io.Serializable;
import java.util.HashSet;

public class WorkflowModel implements Serializable {
    private HashSet<WorkflowVertex> vertexes = new HashSet<>();
    private HashSet<WorkflowEdge> edges = new HashSet<>();
    private HashSet<VertexConnect> connects = new HashSet<>();

    private double sizeX = 0; // size X of canvas of workflow
    private double sizeY = 0; // size Y of canvas of workflow

    public WorkflowModel() {

    }

    public double getSizeX() {
        return sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public HashSet<WorkflowVertex> getVertexes() {
        return this.vertexes;
    }

    public HashSet<WorkflowEdge> getEdges() {
        return this.edges;
    }

    public HashSet<VertexConnect> getConnects() {
        return this.connects;
    }

    public void addVertex(WorkflowVertex v){
        this.vertexes.add(v);
    }

    public void addEdge(WorkflowEdge e){
        this.edges.add(e);
    }

    public void addConnect(VertexConnect c){
        this.connects.add(c);
    }

    public void removeVertex(WorkflowVertex v){
        this.vertexes.remove(v);
    }

    public void removeEdge(WorkflowEdge e){
        this.edges.remove(e);
    }

    public void removeConnect(VertexConnect c){
        this.connects.remove(c);
    }

    /**
     * merge all edges and vertexes from gModel into this graph
     * all loaded, new and deleted
     * @param gModel
     */
    public void merge(WorkflowModel gModel){
        this.vertexes.addAll(gModel.getVertexes());
        this.edges.addAll(gModel.getEdges());
    }

    public void clear(){
        this.edges.clear();
        this.vertexes.clear();
    }



}
