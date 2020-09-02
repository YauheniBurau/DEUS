package core.application.gui.workflowFxComponent.param

/**
 * Created by anonymous on 26.03.2019.
 * start refactor 09.07.2020
 */
class FileSelect {
    private File file;
    private String fileChooserTitle;
    private File fileChooserInitialDirectory;
    private String fileChooserComment;
    private String[] extensions;
    private ShowDialogEnum showDialogType;

    String getFileExtension(){
        String fileName;
        String fileExtension = null;
        if(this.file!=null && file.isFile()) {
            fileName = file.getName();
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, file.getName().length());
        }
        return fileExtension;
    }

    /**
     *
     * @return WFS - workflow scheme *.wfs
     */
    static FileSelect fileWFS(){
        return new FileSelect(file : new File(System.getProperty("user.home") + "\\file.wfs"),
                fileChooserTitle : "Select file *.wfs",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment : "select *.wfs",
                extensions : new String[]{"*.wfs"}
        )
    }

    /**
     *
     * @return WFV - workflow scheme *.wfv
     */
    static FileSelect fileWFV(){
        return new FileSelect(
                file : new File(System.getProperty("user.home") + "\\file.wfv"),
                fileChooserTitle : "Select file *.wfv",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment :"select *.wfv",
                extensions : new String[]{"*.wfv"}
        )
    }

    /**
     *
     * @return file - *.png *.bmp *.jpg
     */
    static FileSelect filePngBmpJpg(){
        return new FileSelect(
                file : new File(System.getProperty("user.home") + "\\Image.jpg"),
                fileChooserTitle : "Select file *.png *.bmp *.jpg",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment : "select *.png *.bmp *.jpg",
                extensions : new String[]{"*.png", "*.bmp", "*.jpg"}
        )
    }

    /**
     *
     * @return file directory
     */
    static FileSelect fileDirectory(){
        return new FileSelect(
                file : new File(System.getProperty("user.home")),
                fileChooserTitle : "Select Directory",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment : "select Directory",
                extensions : new String[]{"."}
        )
    }

    /**
     *
     * @return file *.class java
     */
    static FileSelect fileClass(){
        return new FileSelect(
                file : new File(System.getProperty("user.home")),
                fileChooserTitle : "Select file *.class",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment : "Select file *.class",
                extensions : new String[]{"*.class"}
        )
    }

    /**
     *
     * @return file *.class java
     */
    static FileSelect fileEmpty(){
        return new FileSelect(
                file : new File(System.getProperty("user.home")),
                fileChooserTitle : "Select file *.*",
                fileChooserInitialDirectory : new File(System.getProperty("user.home")),
                fileChooserComment : "Select file *.empty",
                extensions : new String[]{"*.empty"})
    }

}