package core.application.gui.graphFxComponent.model;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Polar3d {
    private double r;
    private double latitudeAngle;
    private double longitudeAngle;

    public Polar3d(double r, double latitudeAngle, double longitudeAngle) {
        this.r = r;
        this.latitudeAngle = latitudeAngle;
        this.longitudeAngle = longitudeAngle;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getLatitudeAngle() {
        return latitudeAngle;
    }

    public void setLatitudeAngle(double latitudeAngle) {
        this.latitudeAngle = latitudeAngle;
    }

    public double getLongitudeAngle() {
        return longitudeAngle;
    }

    public void setLongitudeAngle(double longitudeAngle) {
        this.longitudeAngle = longitudeAngle;
    }

    /**
     * convert to Decart3d
     * @return converted Polar2d into Decart3d
     */
    public Decart3d toDecart3d(){
        return new Decart3d(
                this.getR()* sin(this.getLatitudeAngle()) * cos(this.getLongitudeAngle()),
                this.getR()* sin(this.getLatitudeAngle()) * sin(this.getLongitudeAngle()),
                this.getR()* cos(this.getLatitudeAngle())
        );
    }

}
