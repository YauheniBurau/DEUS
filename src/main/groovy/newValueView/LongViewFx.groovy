package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.util.StringConverter

class LongViewFx extends Pane implements IValueViewFx<Long>{
    TextField txtField

    @Override
    void updateView() {
        StringConverter<Long> formatter = new StringConverter<Long>() {
            @Override
            Long fromString(String string){
                return Long.parseLong(string)
            }
            @Override
            String toString(Long object){
                if (object == null)
                    return "0";
                return object.toString()
            }
        }
        this.txtField = new TextField(this.value.toString())
        this.txtField.setTextFormatter(new TextFormatter<Long>(formatter))
        Label lbl = new Label("long")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel() {
        this.value = this.txtField.getTextFormatter().getValue()
    }
}
