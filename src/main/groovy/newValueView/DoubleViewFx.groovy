package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.util.StringConverter

class DoubleViewFx extends Pane implements IValueViewFx<Double>{
    TextField txtField

    @Override
    void updateView() {
        StringConverter<Double> formatter = new StringConverter<Double>() {
            @Override
            Double fromString(String string){
                return Double.parseDouble(string)
            }
            @Override
            String toString(Double object){
                if (object == null)
                    return "0.0";
                return object.toString()
            }
        }
        this.txtField = new TextField(this.value.toString())
        this.txtField.setTextFormatter(new TextFormatter<Double>(formatter))
        Label lbl = new Label("double")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel() {
        this.value = this.txtField.getTextFormatter().getValue()
    }

}
