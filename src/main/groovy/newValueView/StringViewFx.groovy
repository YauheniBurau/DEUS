package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

class StringViewFx extends Pane implements IValueViewFx<String>{
    TextField txtField

    @Override
    void updateView(){
        this.txtField = new TextField(this.value)
        Label lbl = new Label("string")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel(){
        this.value = this.txtField.getText()
    }
}
