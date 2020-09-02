package newWorkflowFx

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button

class WVertexAddBtnFx extends Button{

    WVertexAddBtnFx(EventHandler<ActionEvent> e){
        this.setText("add")
        this.setOnAction(e)
    }

}
