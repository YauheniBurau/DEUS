package core.application.gui.graphFxComponent.view;

import core.application.gui.graphFxComponent.model.Decart3d;
import core.application.gui.graphFxComponent.model.Polar3d;
import javafx.scene.layout.Pane;

import java.util.HashSet;

public class Graph2dFx extends Pane {
    private HashSet<Vertex2dFx> vertexes = new HashSet<>();
    private HashSet<Edge2dFx> edges = new HashSet<>();

    public Graph2dFx() {

    }

    //==================================================================================================================
    public HashSet<Vertex2dFx> getVertexes() {
        return vertexes;
    }

    public HashSet<Edge2dFx> getEdges() {
        return edges;
    }

    //==================================================================================================================
    public void addVertex(Vertex2dFx v){
        this.vertexes.add(v);
        this.getChildren().add(v);
    }

    public void addEdge(Edge2dFx e){
        this.edges.add(e);
        this.getChildren().add(e);
    }

    public void deleteVertex(Vertex2dFx v){
        this.getChildren().remove(v);
        this.vertexes.remove(v);
    }

    public void deleteEdge(Edge2dFx e){
        this.getChildren().remove(e);
        this.edges.remove(e);
    }

    /**
     * remove all Edge2dFx and Vertex2dFx from scene and clear sets
     */
    public void clear(){
        this.getChildren().clear();
        this.edges.clear();
        this.vertexes.clear();
    }
    //==================================================================================================================
    /**
     * order vertexes and connected edges, randomly in sphere of radius 'sphereRadius'
     * @param sphereRadius
     */
    public void orderVertexesInSphere(int sphereRadius){
        double r;
        double latitudeAngle;
        double longitudeAngle;
        Decart3d p3d;
        for(Vertex2dFx v: this.vertexes) {
            r = Math.random()*sphereRadius;
            latitudeAngle = Math.random()*2*Math.PI;
            longitudeAngle = Math.random()*2*Math.PI;
            p3d = new Polar3d(r, latitudeAngle, longitudeAngle).toDecart3d();
            v.x().set(p3d.getX());
            v.y().set(p3d.getY());
            v.z().set(p3d.getZ());
        }
    }

}