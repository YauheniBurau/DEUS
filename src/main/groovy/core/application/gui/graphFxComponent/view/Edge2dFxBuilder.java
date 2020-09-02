package core.application.gui.graphFxComponent.view;

import javafx.scene.paint.Paint;

public class Edge2dFxBuilder {
    private Edge2dFx e;

    public Edge2dFxBuilder(Vertex2dFx v1, Vertex2dFx v2) {
        e = new Edge2dFx(v1, v2);
    }

    public Edge2dFxBuilder withTextVisible(boolean isVisible){
        this.e.setTextVisible(isVisible);
        return this;
    }

    public Edge2dFxBuilder withText(String txt){
        this.e.setText(txt);
        return this;
    }

    public Edge2dFxBuilder withTextFill(Paint paint){
        this.e.setTextFill(paint);
        return this;
    }

    public Edge2dFxBuilder withCurveFill(Paint paint){
        this.e.setCurveFill(paint);
        return this;
    }

    public Edge2dFx build(){
        return this.e;
    }

}
