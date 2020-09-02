package core.application.gui.factoryFx;

import javafx.stage.DirectoryChooser;

public class DirectoryChooserFxFactory {

    /**
     * create javaFX directoryChooser
     * @param title
     * @param initialDirectory
     * @return
     */
    static DirectoryChooser create(String title, File initialDirectory){
        DirectoryChooser dc = new DirectoryChooser()
                dc.setTitle(title)
                dc.setInitialDirectory(initialDirectory)
        return dc
    }


}
