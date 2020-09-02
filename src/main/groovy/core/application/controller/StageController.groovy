package core.application.controller

import javafx.stage.Stage

/**
 * base controllers for manipulation with any StageFX object
 */
class StageController {

    static Boolean showStage(Stage stg) {
        Boolean result = true
        if(!stg.isShowing()) stg.show()
        return result
    }

    static Boolean hideStage(Stage stg) {
        Boolean result = true
        if(stg.isShowing()) stg.hide()
        return result
    }

}
