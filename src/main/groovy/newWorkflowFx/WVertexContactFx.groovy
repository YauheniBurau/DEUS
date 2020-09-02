package newWorkflowFx

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.effect.Bloom
import javafx.scene.input.DragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.SVGPath
import newValueView.IValueViewFx
import newValueView.ValueViewFxFactory

class WVertexContactFx extends HBox{
    private IValueViewFx valueViewFx
    private Pane contactFx = new Pane()
    private ArrayList<WVertexConnectorFx> inputsConnectors = new ArrayList<>()
    private ArrayList<WVertexConnectorFx> outputsConnectors = new ArrayList<>()
    private boolean isInput = true

    WVertexContactFx(boolean isInput, Class<?> type){
        // init
        this.contactFx.setPadding(new Insets(5, 5,5,5))
        this.contactFx.setOnMouseEntered(hOnMouseEntered)
        this.contactFx.setOnMouseExited(hOnMouseExited)
//        this.contactFx.setOnMousePressed(hOnMousePressed)
//        this.contactFx.setOnDragDone(hOnDragDone)

        this.isInput = isInput
        // setup view
        this.setViewFx( ValueViewFxFactory.create(type) )
        this.setContactColor(Color.YELLOW)
        this.setContactShape(ShapeSvgPathEnum.OVAL)
        this.setContactSize(10)
    }

    String getContactShape(){

    }

    void setContactShape(String value){
        SVGPath path = new SVGPath()
        path.setContent(value)
        this.contactFx.setShape(path)
    }

    void setContactShape(ShapeSvgPathEnum value){
        SVGPath path = new SVGPath()
        path.setContent(value.value())
        this.contactFx.setShape(path)
    }

    void setContactColor(Color value){
        this.contactFx.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) )
        this.contactFx.setBackground(
                new Background(
                        new BackgroundFill(value, CornerRadii.EMPTY, Insets.EMPTY)
                )
        )
    }

    Color getContactColor(){
        return null
    }

    void setContactSize(double value){
        this.contactFx.setMinSize(value, value)
        this.contactFx.setMaxSize(value, value)
    }

    double getContactSize(){
        return this.contactFx.getMinWidth()
    }

    boolean isInput(){
        return this.isInput
    }

    void isInput(boolean value){

    }

    IValueViewFx getViewFx(){
        return this.valueViewFx
    }

    void setViewFx(IValueViewFx value){
        this.getChildren().clear()
        this.valueViewFx = value
        isInput ? this.getChildren().addAll(this.contactFx, this.valueViewFx) : this.getChildren().addAll(this.valueViewFx, this.contactFx)
        this.setAlignment(Pos.BASELINE_CENTER)
    }

    def getContactValue(){
        return this.valueViewFx.getValue()
    }

    void setContactValue(def value){
        this.valueViewFx.init(value)
    }

    Pane getContactFx(){
        return this.contactFx
    }

    /**
     * change Contact color if mouse on it
     */
    private EventHandler<MouseEvent> hOnMouseEntered = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            Bloom bloom = new Bloom()
            bloom.setThreshold(2.0)
            this.contactFx.setEffect(bloom)
        }
    }

    /**
     * change change Contact color if mouse not on it
     */
    private EventHandler<MouseEvent> hOnMouseExited = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            this.contactFx.setEffect(null)
        }
    }

}