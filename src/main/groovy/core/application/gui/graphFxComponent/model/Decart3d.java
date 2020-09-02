package core.application.gui.graphFxComponent.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by anonymous on 03.11.2018.
 */
public class Decart3d {
    public SimpleDoubleProperty x;
    public SimpleDoubleProperty y;
    public SimpleDoubleProperty z;

    public Decart3d() {
        this.x = new SimpleDoubleProperty(0.0);
        this.y = new SimpleDoubleProperty(0.0);
        this.z = new SimpleDoubleProperty(0.0);
    }

    public Decart3d(double x, double y, double z) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.z = new SimpleDoubleProperty(z);
    }

    public double getX() {
        return x.get();
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getZ() {
        return z.get();
    }

    public void setZ(double z) {
        this.z.set(z);
    }

    public DoubleProperty xProperty() {
        return this.x;
    }

    public DoubleProperty yProperty() {
        return this.y;
    }

    public DoubleProperty zProperty() {
        return this.z;
    }

    /**
     * convert to Polar3d
     * @return
     */
    public Polar3d toPolar3d(){
        double r = 0;
        double latitude = 0;
        double longitude = 0;
        // R
        r = Math.sqrt( this.x.get() * this.x.get() + this.y.get() * this.y.get() + this.z.get() * this.z.get());
        // Latitude
        if(this.z.get()==0.0){ latitude = 0;}
        else{ latitude = Math.acos(this.z.get()/r); }
        // Longitude
//        if(decart3d.x==0.0 && decart3d.y>0) longitude = Math.PI/2;
//        if(decart3d.x==0.0 && decart3d.y<0) longitude = Math.PI*3/4;
//        if(decart3d.x==0.0 && decart3d.y==0) longitude = 0;
        if(this.x.get()!=0.0 && this.y.get()!=0.0){ longitude = Math.atan2(this.y.get(), this.x.get()); }
        return new Polar3d(r, latitude, longitude);
    }
}
