package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.util.StringConverter

class IntegerViewFx extends Pane implements IValueViewFx<Integer>{
    TextField txtField

    @Override
    void updateView(){
        StringConverter<Integer> formatter = new StringConverter<Integer>() {
            @Override
            Integer fromString(String string){
                return Integer.parseInt(string)
            }
            @Override
            String toString(Integer object){
                if (object == null) return "0"
                return object.toString()
            }
        }
        this.txtField = new TextField(this.value.toString())
        this.txtField.setTextFormatter(new TextFormatter<Integer>(formatter))
        Label lbl = new Label("integer")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel(){
        this.value = this.txtField.getTextFormatter().getValue()
    }

}
