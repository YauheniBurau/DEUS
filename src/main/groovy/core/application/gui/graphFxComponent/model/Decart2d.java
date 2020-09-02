package core.application.gui.graphFxComponent.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Decart2d {
    public SimpleDoubleProperty x;
    public SimpleDoubleProperty y;

    public Decart2d() {
        this.x = new SimpleDoubleProperty(0.0);
        this.y = new SimpleDoubleProperty(0.0);
    }

    public Decart2d(double x, double y) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
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


    public DoubleProperty xProperty() {
        return this.x;
    }

    public DoubleProperty yProperty() {
        return this.y;
    }

    /**
     * convert to Polar2d
     * @return
     */
    public Polar2d toPolar2d(){
        double r = 0;
        double longitude = 0;
        // R
        r = Math.sqrt( this.x.get() * this.x.get() + this.y.get() * this.y.get());
        if(this.x.get()!=0.0 && this.y.get()!=0.0){ longitude = Math.atan2(this.y.get(), this.x.get()); }
        return new Polar2d(r, longitude);
    }

}
