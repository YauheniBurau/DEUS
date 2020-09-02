package newValueView

import javafx.collections.FXCollections
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

class BoolViewFx extends Pane implements IValueViewFx<Boolean>{
    ChoiceBox choiceBox = new ChoiceBox( FXCollections.observableArrayList(true, false) )

    @Override
    void updateView() {
        Label lbl = new Label("boolean")
        this.getChildren().add( new VBox(lbl, this.choiceBox) )
    }

    @Override
    void updateToModel() {
        this.value = choiceBox.getValue()
    }
}
