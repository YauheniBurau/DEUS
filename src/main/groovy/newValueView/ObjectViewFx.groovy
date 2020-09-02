package newValueView

import javafx.scene.control.Label
import javafx.scene.layout.Pane

class ObjectViewFx extends Pane implements IValueViewFx<Object>{
    Label lbl

    @Override
    void updateView() {
        lbl = new Label('obj:' + this.value.getClass().getSimpleName())
        this.getChildren().clear()
        this.getChildren().add(lbl)
    }

    @Override
    void updateToModel() {

    }

}
