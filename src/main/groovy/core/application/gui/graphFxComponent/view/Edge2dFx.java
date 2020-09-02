package core.application.gui.graphFxComponent.view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Edge2dFx extends Group {
    private Line curve = new Line();
    private Text text = new Text();
    private Arrow2dFx arrow = new Arrow2dFx();

    public Edge2dFx(Vertex2dFx v1, Vertex2dFx v2) {
        this.attachCurve(v1, v2);
        this.attachArrow();
        this.attachText();
        this.setText("E");
        this.setTextFill(Color.BLUE);
        this.setCurveFill(Color.BLUE);
        this.getChildren().addAll(curve, arrow, text);
    }

    public Line curve() {
        return curve;
    }

    public Text text() {
        return text;
    }

    public Arrow2dFx arrow() {
        return arrow;
    }

    public void setCurveFill(Paint paint) {
        this.curve.setFill(paint);
        this.curve.setStroke(paint);
        this.arrow.setFill(paint);
        this.arrow.setStroke(paint);
    }

    public void setTextFill(Paint paint) {
        this.text.setFill(paint);
    }

    public void setText(String text){
        this.text.setText(text);
    }

    public void setArrowVisible(boolean isVisible){
        this.arrow.setVisible(isVisible);
    }

    public void setTextVisible(boolean isVisible){
        this.text.setVisible(isVisible);
    }


    private void attachText() {
        text.layoutXProperty().bind(this.curve.startXProperty().add(this.curve.endXProperty()).divide(2).subtract(text.getLayoutBounds().getWidth() / 2));
        text.layoutYProperty().bind(this.curve.startYProperty().add(this.curve.endYProperty()).divide(2).add(text.getLayoutBounds().getHeight() / 1.5));
    }

    private void attachArrow() {
        /* attach arrow to line's endpoint */
        arrow.layoutXProperty().bind(curve.endXProperty());
        arrow.layoutYProperty().bind(curve.endYProperty());
        /* rotate arrow around itself based on this line's angle */
        Rotate rotation = new Rotate();
        rotation.angleProperty().bind( UtilitiesBindings.toDegrees(
                UtilitiesBindings.atan2( this.curve.endYProperty().subtract(this.curve.startYProperty()),
                        this.curve.endXProperty().subtract(this.curve.startXProperty()))
        ));
        arrow.getTransforms().add(rotation);
    }

    private void attachCurve(Vertex2dFx v1, Vertex2dFx v2) {
        curve.startXProperty().bind(v1.circle().centerXProperty());
        curve.startYProperty().bind(v1.circle().centerYProperty());
        curve.endXProperty().bind(v2.circle().centerXProperty());
        curve.endYProperty().bind(v2.circle().centerYProperty());
    }

}
