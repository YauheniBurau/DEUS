package core.application.gui.factoryFx;

import javafx.scene.image.ImageView;

class ImageViewFxFactory {

    /**
     * create JavaFX ImageView
     * @return
     */
    static ImageView create(int sizeX, int sizeY) {
        ImageView img = new ImageView()
                img.setFitWidth(sizeX)
                img.setFitHeight(sizeY)
                img.setPreserveRatio(true)
        return img
    }


}
