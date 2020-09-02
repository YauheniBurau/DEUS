package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.VertexConnect;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class VertexConnect2dFx extends Pane {
    private WorkflowVertex2dFx vertex2dFx;
    private VertexConnect model;

    public VertexConnect2dFx(WorkflowVertex2dFx vertex2dFx, VertexConnect model){
        this.vertex2dFx = vertex2dFx;
        this.model = model;
        this.updateFromModel();
    }

    public void setStyles(String shape_svg_path, Color backgroundColor){
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        this.setBackground(
                new Background(
                        new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)
                )
        );
        SVGPath path = new SVGPath();
        path.setContent(shape_svg_path);
        this.setShape(path);
    }

    public void setSize(double size){
        this.setMinSize(size, size);
        this.setMaxSize(size, size);
    }

    /**
     * this type of set is like binding with parent layout in expression of relative coordinates
     * @param x -1..+1
     * @param y -1..+1
     */
    public void setRelativeLayoutXY(double x, double y){
//        BindingFx.bind(vertex2dFx, this, x, y);
        this.layoutXProperty().unbind();
        this.layoutXProperty().bind(vertex2dFx.widthProperty()
                .divide(2)
                .subtract(this.widthProperty().divide(2))
                .add(vertex2dFx.widthProperty().divide(2).multiply(x))
        );
        this.layoutYProperty().unbind();
        this.layoutYProperty().bind(vertex2dFx.heightProperty()
                .divide(2)
                .subtract(this.heightProperty().divide(2))
                .add(vertex2dFx.heightProperty().divide(2).multiply(y))
        );
    }

    public WorkflowVertex2dFx getVertex2dFx() {
        return vertex2dFx;
    }

    public void setVertex2dFx(WorkflowVertex2dFx vertex2dFx) {
        this.vertex2dFx = vertex2dFx;
    }

    public VertexConnect getModel() {
        return model;
    }

    public void setModel(VertexConnect model) {
        this.model = model;
    }


    public void updateToModel(){
        throw new RuntimeException("Not implemented");
    }

    public void updateFromModel(){
        this.setSize(model.getSize());
        this.setStyles(model.getShapeSvgPath(), model.getBackgroundColor());
        this.setRelativeLayoutXY(model.getX(), model.getY());
    }
}



// TODO: remove later

//    /**
//     * change circle input if mouse on it
//     */
//    private EventHandler<DragEvent> hOnDragEntered = (e) -> {
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
//        if(newConnectionFX != null) {
//            OutputFX start = newConnectionFX.getStart();
//            if(start.getValue().getClassValue() == this.getValue().getClassValue() &&
//                this.getValue().getConnections().size() == 0){
//                circle.setFill(Color.LIGHTGREEN);
//            }else{
//                circle.setFill(Color.RED);
//            }
//            newConnectionFX.setEnd(this);
//        }
//        e.consume();
//    };
//
//    /**
//     * change circle output if mouse not on it
//     */
//    private EventHandler<DragEvent> hOnDragExited = (e) -> {
//        circle.setFill(Color.BLACK);
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
//        newConnectionFX.setEnd1( newConnectionFX.getEnd1() );
//        e.consume();
//    };
//
//    /**
//     * finish connection output with input
//     */
//    private EventHandler<DragEvent> hOnDragDropped = (e)->{
//        boolean isSuccess = false;
//        if( e.getGestureSource() instanceof ConnectionFX){
//            ConnectionFX connFX = this.getNodeFX().getWorkflowFX().getTempConnectionFX();
//            OutputFX start = connFX.getStart();
//            if(start.getValue().getClassValue() == this.getValue().getClassValue()
//                    && this.getValue().getConnections().size() == 0)
//            {
//                isSuccess = true;
//                this.getNodeFX().getWorkflowFX().getChildren().remove(connFX.getEnd1());
//                connFX.setEnd1(null);
//                connFX.setEnd(this);
//            }
//        }
//        e.setDropCompleted(isSuccess);
//        //e.consume();
//    };

//    private void init(T value) {
//        this.circle.setOnDragEntered(hOnDragEntered);
//        this.circle.setOnDragExited(hOnDragExited);
//        this.circle.setOnDragDropped(hOnDragDropped);
//    }

//    private EventHandler<MouseEvent> hOnDragDetected = (e)->{
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX tempConnectionFX;
//        if(wfFX.getTempConnectionFX() == null) {
//            tempConnectionFX = wfFX.createTempConnectionFX(this);
//            Dragboard db = tempConnectionFX.startDragAndDrop(TransferMode.ANY);
//            ClipboardContent content = new ClipboardContent();
//            content.putString("TempConnectionFX");
//            db.setContent(content);
//        }
//        e.consume();
//    };
