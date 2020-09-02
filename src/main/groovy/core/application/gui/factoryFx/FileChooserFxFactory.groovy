package core.application.gui.factoryFx

import core.application.gui.workflowFxComponent.param.FileSelect
import core.application.gui.workflowFxComponent.param.ShowDialogEnum
import javafx.stage.FileChooser
import javafx.stage.Window

class FileChooserFxFactory {

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param extFilter
     * @return
     */
    static FileChooser createFileChooser(String title, File initialDirectory, FileChooser.ExtensionFilter extFilter){
        FileChooser fc = new FileChooser()
        fc.setTitle(title)
        fc.setInitialDirectory(initialDirectory)
        fc.getExtensionFilters().add(extFilter)
        return fc
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param comment
     * @param extensions
     * @return
     */
    static FileChooser createFileChooser(String title, File initialDirectory, String comment, String... extensions){
        FileChooser.ExtensionFilter extFilter = ExtensionFilterFxFactory.createFileChooserExtensionFilter(comment, extensions)
        return FileChooserFxFactory.createFileChooser(title, initialDirectory, extFilter)
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param fParam
     * @return
     */
    static FileChooser createFileChooser(FileSelect fParam){
        return FileChooserFxFactory.createFileChooser(
                fParam.fileChooserTitle,
                fParam.fileChooserInitialDirectory,
                fParam.fileChooserComment,
                fParam.extensions
        )
    }

    /**
     * create fileChooser from Object "FileParam" and run it accordingly param 'showDialogType' in fParam
     * @param fParam
     * @param wnd
     * @return
     */
    static List<File> runFileChooser(FileSelect fParam, Window wnd){
        FileChooser fc = FileChooserFxFactory.createFileChooser(fParam)
        File f;
        List<File> listFile = new ArrayList<>();
        switch(fParam.showDialogType){
            case ShowDialogEnum.SHOW_OPEN_DIALOG:
                f = fc.showOpenDialog(wnd);
                if(f!=null){ listFile.add(f);}
                break;
            case ShowDialogEnum.SHOW_SAVE_DIALOG:
                f = fc.showSaveDialog(wnd);
                if(f!=null){ listFile.add(f);}
                break;
            case ShowDialogEnum.SHOW_OPEN_MULTIPLE_DIALOG:
                listFile = fc.showOpenMultipleDialog(wnd);
                break;
        }
        return listFile;
    }
}
