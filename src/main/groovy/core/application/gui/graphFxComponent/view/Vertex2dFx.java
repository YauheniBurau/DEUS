package core.application.gui.graphFxComponent.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Vertex2dFx extends Group {
    public SimpleDoubleProperty x = new SimpleDoubleProperty();
    public SimpleDoubleProperty y = new SimpleDoubleProperty();
    public SimpleDoubleProperty z = new SimpleDoubleProperty();
    private Circle circle = new Circle();
    private Text txt = new Text();
    private ImageView image = null;

    public Vertex2dFx() {
        this.setCircleRadius(10);
        this.setCircleFill(Color.LIGHTGREEN);
        this.setTextFill(Color.LIGHTGREEN);
        this.setText("V");
        this.attachCircle();
        this.attachText();
        this.attachImage();
        this.getChildren().addAll(circle, txt);
    }

    public SimpleDoubleProperty x(){
        return this.x;
    }

    public SimpleDoubleProperty y(){
        return this.y;
    }

    public SimpleDoubleProperty z(){
        return this.z;
    }

    public Circle circle() {
        return circle;
    }

    public Text txt() {
        return this.txt;
    }

    public ImageView image() {
        return this.image;
    }

    public void setText(String text){
        this.txt.setText(text);
    }

    public void setTextVisible(boolean isVisible){
        this.txt.setVisible(isVisible);
    }

    public void setTextFill(Paint paint) {
        this.txt.setFill(paint);
    }

    public void setImageVisible(boolean isVisible){
        if(image !=null){
            if(isVisible){
                this.getChildren().remove(image);
            }else{
                this.getChildren().add(image);
            }

        }
    }

    public void setCircleFill(Paint paint){
        this.circle.setFill(paint);
    }

    public void setCircleRadius(double radius){
        this.circle.setRadius(radius);
    }

    public void setImage(ImageView image){
        throw new RuntimeException("Not implemented");
    };

    private void attachCircle(){
        // bind circle coordinates with xyz
        circle.centerXProperty().bind(x);
        circle.centerYProperty().bind(y);
    }

    private void attachText(){
        // bind label coordinates with circle
        txt.layoutXProperty().bind(this.circle.centerXProperty().subtract(txt.getLayoutBounds().getWidth() / 2));
        txt.layoutYProperty().bind(this.circle.centerYProperty().add(txt.getLayoutBounds().getHeight() / 1.5));
    }

    private void attachImage(){

    }

}
