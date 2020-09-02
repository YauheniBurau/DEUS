package core.application.gui.workflowFxComponent.view;

import core.application.gui.factoryFx.PropertySheetFxFactory;
import core.application.gui.workflowFxComponent.binding.BindingFx;
import core.application.gui.workflowFxComponent.model.VertexConnect;
import core.application.gui.workflowFxComponent.model.VertexDataBeanTypeEnum;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.workflowFxComponent.propertyEditors.PropertyEditorCallback;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import newWorkflowFx.MakeWVertexFxDruggable;
import newWorkflowFx.MakeWVertexFxResizable;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanPropertyUtils;

import java.util.HashSet;

public class WorkflowVertex2dFx extends Pane {
    private WorkflowVertex model;
    private Label textNameFx = new Label("");
    private HashSet<VertexConnect2dFx> connects2dFx = new HashSet<>();
    private PropertySheet paramSheet = PropertySheetFxFactory.newPropertySheet(
            false, false, false, new PropertyEditorCallback(), null);

    public WorkflowVertex2dFx(WorkflowVertex model) {
        this.model = model;
        this.getChildren().addAll(textNameFx, paramSheet);
        this.updateFromModel(false);
//        MakeWVertexFxResizable.makeResizable(this);
//        MakeWVertexFxDruggable.makeDruggable(this);
    }

    public Label getTextNameFx() {
        return textNameFx;
    }

    private void setStyles(String shape_svg_path, Color fx_background_color){
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        SVGPath path = new SVGPath();
        path.setContent(shape_svg_path);
        this.setShape(path);
    }

    private void setVertexBackground(Color color, Image img, boolean withImage){
        if( img!=null && withImage ){
            BackgroundSize bgs = new BackgroundSize(this.getWidth(), this.getHeight(), false, false, true, true);
            BackgroundImage bgImage = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    bgs);
            Background bg = new Background(bgImage);
            this.setBackground(bg);
        }else{
            this.setBackground(
                    new Background(
                            new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );
        }
    }

    private void setSize(double x, double y){
        this.setMinSize(x, y);
        this.setMaxSize(x, y);
    }

    private void setLayoutXY(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    private void setName(String name){
        this.textNameFx.setText(name);
    }

    /**
     * this type of set is like binding with parent layout in expression of relative coordinates
     * @param x -1..+1
     * @param y -1..+1
     */
    private void setNameRelativeXY(double x, double y){
        //BindingFx.bind(this, this.textNameFx, x, y);
        textNameFx.layoutXProperty().unbind();
        textNameFx.layoutXProperty().bind(this.widthProperty()
                .divide(2)
                .subtract(textNameFx.widthProperty().divide(2))
                .add(this.widthProperty().divide(2).multiply(x))
        );
        textNameFx.layoutYProperty().unbind();
        textNameFx.layoutYProperty().bind(this.heightProperty()
                .divide(2)
                .subtract(textNameFx.heightProperty().divide(2))
                .add(this.heightProperty().divide(2).multiply(y))
        );
    }


    /**
     * @param connect2dFx
     */
    public void addConnect2dFx(VertexConnect2dFx connect2dFx){
        this.connects2dFx.add(connect2dFx);
        if(!this.getChildren().contains(connect2dFx) ) this.getChildren().add(connect2dFx);
    }

    public HashSet<VertexConnect2dFx> getConnects2dFx() {
        return connects2dFx;
    }

    public WorkflowVertex getModel() {
        return model;
    }

    public void setModel(WorkflowVertex model) {
        this.model = model;
    }

    public void updateToModel(){
        throw new RuntimeException("Not implemented");
    }

    /**
     *
     * @param isUpdateVertexConnects that parameter is for loading serializable object because if you load
     *                               WorkflowVertex you don't need create VertexConnects again from 'staticMethod'
     */
    public void updateFromModel(boolean isUpdateVertexConnects){
        // update workflowVertex
        this.setSize(this.model.getSizeX(), this.model.getSizeY());
        this.setStyles(this.model.getShapeSvgPath(), this.model.getBackgroundColor());
        this.setVertexBackground(
                this.model.getBackgroundColor(),
                this.model.getBackgroundImage().getValue(),
                this.model.isShownBackgroundImage()
        );
        this.setLayoutXY(this.model.getLayoutX(), this.model.getLayoutY());
        // update label 'Name'
        this.setName(this.model.getName());
        this.setNameRelativeXY(this.model.getNameRelativeX(), this.model.getNameRelativeY());
        // update vertexConnects
        if( isUpdateVertexConnects ){
            this.model.updateStaticMethodConnects();
            this.model.updateDataBeanConnect();
        }
        this.getChildren().removeAll(this.connects2dFx);
        this.connects2dFx.clear();
        VertexConnect2dFx cFx;
        // update vertex connects from model.vertexConnects and from model.vertexDataBean
        for (VertexConnect c: model.selectVertexConnects() ) {
            cFx = new VertexConnect2dFx(this, c);
            this.addConnect2dFx(cFx);
        }
        // update propertySheet with model.vertexDataBean
        if(this.getModel().getVertexDataBeanType() != VertexDataBeanTypeEnum.EMPTY) {
            this.paramSheet.getItems().clear();
            this.paramSheet.setVisible(true);
            this.paramSheet.getItems().addAll(BeanPropertyUtils.getProperties(this.getModel().getVertexDataBean()));
            BindingFx.bind(this, this.paramSheet, 0, 0);
        }else{
            this.paramSheet.setVisible(false);
        }
        // set contextMenu on title of Vertex
        //this.textNameFx.setContextMenu(WorkflowContextMenusFxFactory.workflowVertexContextMenu(this));
    }
}
