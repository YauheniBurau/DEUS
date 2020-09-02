package core.old;

import javafx.scene.shape.Cylinder;

public class EdgeFX extends Cylinder {
//    private ClusterFX vertexU; // begin point of arrow
//    private ClusterFX vertexV; // end point of arrow
//
//    public EdgeFX(int divisions, ClusterFX vertexU, ClusterFX vertexV) {
//        super(1,1, divisions);
//        this.vertexU = vertexU;
//        this.vertexV = vertexV;
//        this.update();
//    }
//
//
//    public EdgeFX setVertexU(ClusterFX vertexU) {
//        this.vertexU = vertexU;
//        return this;
//    }
//
//    public EdgeFX setVertexV(ClusterFX vertexV) {
//        this.vertexV = vertexV;
//        return this;
//    }

//    /**
//     * read data from graphLayout and update GraphView
//     */
//    public EdgeFX update(){
//        Point3D origin = vertexU.getPosition();
//        Point3D target = vertexV.getPosition();
//        Point3D yAxis = new Point3D(0, 1, 0);
//        Point3D diff = target.subtract(origin);
//        double height = diff.magnitude();
//        Point3D mid = target.midpoint(origin);
//        Translate moveToMidpoint = new Translate(mid.getX(), mid.getY(), mid.getZ());
//        Point3D axisOfRotation = diff.crossProduct(yAxis);
//        double angle = Math.acos(diff.normalize().dotProduct(yAxis));
//        Rotate rotateAroundCenter = new Rotate(-Math.toDegrees(angle), axisOfRotation);
//        this.setHeight(height);
//        this.setMaterial(new PhongMaterial(Color.BLUE));
//        this.getTransforms().removeAll();
//        this.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);
//        return this;
//    }

}
