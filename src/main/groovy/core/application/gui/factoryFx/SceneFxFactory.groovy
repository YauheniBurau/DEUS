package core.application.gui.factoryFx

import javafx.scene.Parent
import javafx.scene.Scene;

class SceneFxFactory {

    /**
     * create default scene with parent node and sizeX and sizeY
     * @param parent
     * @param sizeX
     * @param sizeY
     * @return
     */
    static Scene create(Parent parent, double sizeX, double sizeY){
        return new Scene(parent, sizeX, sizeY)
    }

}
