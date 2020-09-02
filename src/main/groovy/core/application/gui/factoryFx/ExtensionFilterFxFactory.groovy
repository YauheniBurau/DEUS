package core.application.gui.factoryFx

import javafx.stage.FileChooser

class ExtensionFilterFxFactory {

    /**
     * create JavaFX FileChooser.ExtensionFilter
     * @param comment
     * @param extensions
     * @return
     */
    static FileChooser.ExtensionFilter createFileChooserExtensionFilter(String comment, String... extensions){
        return new FileChooser.ExtensionFilter(comment, extensions)
    }

}
