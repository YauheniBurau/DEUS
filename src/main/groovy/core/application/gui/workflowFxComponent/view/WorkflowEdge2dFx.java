package core.application.gui.workflowFxComponent.view;

import core.application.gui.graphFxComponent.view.Arrow2dFx;
import core.application.gui.graphFxComponent.view.UtilitiesBindings;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import newWorkflowFx.WorkflowContextMenusFxFactory;

public class WorkflowEdge2dFx extends Group {
    private WorkflowEdge model;
    private VertexConnect2dFx from;
    private VertexConnect2dFx to;
    private Line curve = new Line();
    private Label text = new Label();
    private Arrow2dFx arrow = new Arrow2dFx();

    public WorkflowEdge2dFx(WorkflowEdge model, VertexConnect2dFx c1, VertexConnect2dFx c2) {
        this.model = model;
        this.from = c1;
        this.to = c2;
        this.attachCurve(c1, c2);
        this.attachArrow();
        this.attachText();
        this.getChildren().addAll(curve, arrow, text);
        this.updateFromModel();
        this.text.setContextMenu(WorkflowContextMenusFxFactory.workflowEdgeContextMenu(this));
    }

    public WorkflowEdge getModel() {
        return model;
    }

    public Line curve() {
        return curve;
    }

    public Label text() {
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
        this.text.setTextFill(paint);
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

    private void attachCurve(VertexConnect2dFx v1, VertexConnect2dFx v2) {
        Pane vFx;
        VertexConnect2dFx cFx;
        vFx = (Pane)v1.getParent();
        cFx = this.getFrom();
        curve.startXProperty().bind(vFx.layoutXProperty().add(
                vFx.widthProperty()
                        .divide(2)
                        .add(vFx.widthProperty().divide(2).multiply(cFx.getModel().getX()))
        ));
        curve.startYProperty().bind(vFx.layoutYProperty().add(
                vFx.heightProperty()
                        .divide(2)
                        .add(vFx.heightProperty().divide(2).multiply(cFx.getModel().getY()))
        ));
        vFx = (Pane)v2.getParent();
        cFx = this.getTo();
        curve.endXProperty().bind(vFx.layoutXProperty().add(
                vFx.widthProperty()
                        .divide(2)
                        .add(vFx.widthProperty().divide(2).multiply(cFx.getModel().getX()))
        ));
        curve.endYProperty().bind(vFx.layoutYProperty().add(
                vFx.heightProperty()
                        .divide(2)
                        .add(vFx.heightProperty().divide(2).multiply(cFx.getModel().getY()))
        ));
    }

    public VertexConnect2dFx getFrom() {
        return from;
    }

    public void setFrom(VertexConnect2dFx from) {
        this.from = from;
    }

    public VertexConnect2dFx getTo() {
        return to;
    }

    public void setTo(VertexConnect2dFx to) {
        this.to = to;
    }

    public void updateToModel(){
        throw new RuntimeException("Not implemented");
    }

    public void updateFromModel(){
        this.setText(model.getName());
        this.setTextFill(model.getTextColor());
        this.setCurveFill(model.getEdgeColor());
        this.setArrowVisible(model.isVisibleArrow());
        this.setTextVisible(model.isVisibleText());
        this.attachCurve(this.from, this.to);
    }
}

// TODO: remove later

//    public ConnectionFX() {
//        this.setOnMouseEntered(hOnMouseEntered);
//        this.setOnMouseExited(hOnMouseExited);
//        this.setOnMousePressed(hOnMousePressed);
//        this.setOnDragDone(hOnDragDone);
//        // style
//        this.setStrokeWidth(2);
//    }


//    public ConnectionFX setEnd1(Circle end1) {
//        if(end1==null){
//            this.end1 = null;
//            this.eX1 = null;
//            this.eY1 = null;
//        }else{
//            this.end1 = end1;
//            this.eX1 = new EndX1Binding();
//            this.eY1 = new EndY1Binding();
//            this.endXProperty().bind(this.eX1);
//            this.endYProperty().bind(this.eY1);
//        }
//        if( this.end1!=null){ this.end1.setVisible(true); }
//        return this;
//    }

//    /**
//     * change Connection color if mouse on it
//     */
//    private EventHandler<MouseEvent> hOnMouseEntered = (e) -> {
//        if (!e.isPrimaryButtonDown()) {
//            Bloom bloom = new Bloom();
//            bloom.setThreshold(2.0);
//            this.setEffect(bloom);
//            this.setStroke(Color.BLUE);
//        }
//    };
//
//    /**
//     * change change Connection color if mouse not on it
//     */
//    private EventHandler<MouseEvent> hOnMouseExited = (e) -> {
//        if (!e.isPrimaryButtonDown()) {
//            this.setEffect(null);
//            this.setStroke(Color.BLACK);
//        }
//    };
//
//    /**
//     * on click show alert to choose delete on leave connection
//     */
//    private EventHandler<MouseEvent> hOnMousePressed = (e) -> {
//        e.consume();
//        WorkflowController.showRemoveConnectionDialog(this.workflowFX.getStage(), this);
//    };
//
//    /**
//     * finish connectionFX for OutputFX and inputFX.
//     * add ConnectionFX to WorkflowFX GUI
//     * add Connection to Workflow Model
//     */
//    private EventHandler<DragEvent> hOnDragDone = (e) ->{
//        WorkflowFX wfFX = this.getWorkflowFX();
//        if(this.getEnd1()==null && this.getEnd()!=null){
//            ConnectionFX conn = new ConnectionFX().setStart(start).setEnd(end);
//            WorkflowController.addConnection(wfFX.getStage(), conn);
//        }
//        wfFX.removeTempConnectionFX();
//        e.consume();
//    };