package core.application.gui.factoryFx;

import javafx.event.EventHandler
import javafx.scene.control.Button

class ButtonFxFactory {

    /**
     * create button with set up eventHandler onClick event
     * @return
     */
    static Button create(String title, EventHandler controller) {
        Button btn = new Button()
        btn.setText(title)
        btn.setOnAction(controller)
        return btn
    }

}
