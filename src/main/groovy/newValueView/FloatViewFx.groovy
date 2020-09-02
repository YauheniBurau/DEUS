package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.util.StringConverter

class FloatViewFx extends Pane implements IValueViewFx<Float>{
    TextField txtField

    @Override
    void updateView() {
        StringConverter<Float> formatter = new StringConverter<Float>() {
            @Override
            Float fromString(String string){
                return Float.parseFloat(string)
            }
            @Override
            String toString(Float object){
                if (object == null)
                    return "0.0";
                return object.toString()
            }
        }
        this.txtField = new TextField(this.value.toString())
        this.txtField.setTextFormatter(new TextFormatter<Float>(formatter))
        Label lbl = new Label("float")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel() {
        this.value = this.txtField.getTextFormatter().getValue()
    }

}
