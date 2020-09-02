package newValueView

import javafx.scene.control.Label
import javafx.scene.layout.Pane

class ClassViewFx extends Pane implements IValueViewFx<Class>{
    Label lbl

    @Override
    void updateView() {
        lbl = new Label('class:' + this.value.getSimpleName())
        this.getChildren().clear()
        this.getChildren().add(lbl)
    }

    @Override
    void updateToModel() {

    }
}
