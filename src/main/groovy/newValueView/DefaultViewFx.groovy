package newValueView

import javafx.scene.control.Label
import javafx.scene.layout.Pane

class DefaultViewFx extends Pane implements IValueViewFx<Object>{
    Label lbl

    @Override
    void updateView() {
        lbl = new Label('Obj:'+ this.value.getClass().getSimpleName())
        this.getChildren().add(lbl)
    }

    @Override
    void updateToModel() {

    }
}
