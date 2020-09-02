package core.application.gui.graphFxComponent.view;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

public class Vertex2dFxBuilder {
    private Vertex2dFx v;

    public Vertex2dFxBuilder() {
        v = new Vertex2dFx();
    }

    public Vertex2dFxBuilder withTextVisible(boolean isVisible){
        this.v.setTextVisible(isVisible);
        return this;
    }

    public Vertex2dFxBuilder withText(String txt){
        this.v.setText(txt);
        return this;
    }

    public Vertex2dFxBuilder withTextFill(Paint paint){
        this.v.setTextFill(paint);
        return this;
    }

    public Vertex2dFxBuilder withImageVisible(boolean isVisible){
        this.v.setImageVisible(isVisible);
        return this;
    }

    public Vertex2dFxBuilder withImage(ImageView image){
        this.v.setImage(image);
        return this;
    }

    public Vertex2dFxBuilder withCircleFill(Paint paint){
        this.v.setCircleFill(paint);
        return this;
    }

    public Vertex2dFxBuilder withCircleSize(double radius){
        this.v.circle().setRadius(radius);
        return this;
    }

    public Vertex2dFx build(){
        return this.v;
    }

}
