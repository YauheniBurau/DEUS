package core.application.gui.factoryFx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

class DialogFxFactory {

    /**
     * open dialog of confirmation to do something
     */
    static Optional<ButtonType> showConfirmDialog(String title, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION)
        alert.setTitle(title)
        alert.setHeaderText(headerText)
        alert.setContentText(contentText)
        return alert.showAndWait()
    }


}
