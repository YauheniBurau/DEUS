package core.application.gui.factoryFx

import javafx.scene.image.Image
import javafx.scene.image.PixelWriter
import javafx.scene.image.WritableImage
import javafx.scene.paint.Color

class WritableImageFxFactory {

    /**
     * create empty image with background color
     * @param sizeX
     * @param sizeY
     * @param clr
     * @return
     */
    static Image create(int sizeX, int sizeY, Color clr){
        WritableImage wi = new WritableImage(128, 128)
        PixelWriter pw = wi.getPixelWriter()
        for(int x=0; x<sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                pw.setColor(x, y, clr)
            }
        }
        return wi;
    }
}
