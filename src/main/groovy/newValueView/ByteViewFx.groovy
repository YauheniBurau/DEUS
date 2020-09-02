package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.util.StringConverter

class ByteViewFx extends Pane implements IValueViewFx<Byte>{
    TextField txtField

    @Override
    void updateView() {
        StringConverter<Byte> formatter = new StringConverter<Byte>() {
            @Override
            Byte fromString(String string){
                return Byte.parseByte(string)
            }
            @Override
            String toString(Byte object){
                if (object == null)
                    return "0";
                return object.toString()
            }
        }
        this.txtField = new TextField(this.value.toString())
        this.txtField.setTextFormatter(new TextFormatter<Byte>(formatter))
        Label lbl = new Label("byte")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel() {
        this.value = this.txtField.getTextFormatter().getValue()
    }
}
