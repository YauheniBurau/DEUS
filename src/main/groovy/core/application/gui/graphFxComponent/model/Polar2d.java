package core.application.gui.graphFxComponent.model;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Polar2d {
    private double r;
    private double longitudeAngle;

    public Polar2d(double r, double longitudeAngle) {
        this.r = r;
        this.longitudeAngle = longitudeAngle;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }


    public double getLongitudeAngle() {
        return longitudeAngle;
    }

    public void setLongitudeAngle(double longitudeAngle) {
        this.longitudeAngle = longitudeAngle;
    }

    /**
     * convert to Decart2d
     * @return converted Polar2d into Decart2d
     */
    public Decart2d toDecart2d(){
        return new Decart2d(
                this.getR() * cos(this.getLongitudeAngle()),
                this.getR() * sin(this.getLongitudeAngle())
        );
    }

}
