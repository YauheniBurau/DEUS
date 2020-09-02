package newValueView

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

class CharViewFx extends Pane implements IValueViewFx<Character>{
    TextField txtField

    @Override
    void updateView(){
        this.txtField = new TextField()
        this.txtField.setText(this.value.toString())
        Label lbl = new Label("char")
        this.getChildren().add( new VBox(lbl, this.txtField) )
    }

    @Override
    void updateToModel(){
        this.value = this.txtField.getText()
    }
}
