package core.application.gui.workflowFxComponent.propertyEditors

import core.application.gui.factoryFx.FileChooserFxFactory
import core.application.gui.workflowFxComponent.param.FileSelect
import core.application.gui.workflowFxComponent.param.ImageSelect
import core.application.gui.workflowFxComponent.param.ShowDialogEnum
import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import org.controlsfx.control.PropertySheet

class ImageSelectEditor extends BasePropertyEditor<ImageSelect> {
    private ImageView imgView;

    ImageSelectEditor(PropertySheet.Item parameter) {
        EventHandler<MouseEvent> hClicked = (e) -> {
            FileSelect fParam = FileSelect.filePngBmpJpg().showDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG)
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, this.getScene().getWindow() )
            if(files.size()==1) {
                try {
                    Image img = new Image(new FileInputStream(files.get(0)),
                            128, 128, false, true);
                    this.setValue(new ImageSelect(img));
                    this.imgView.setImage(this.value.getValue());
                    parameter.setValue(this.value);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        };

        EventHandler<MouseEvent> hEntered = (e) -> {

        }

        EventHandler<MouseEvent> hExited = (e) -> {

        }

        this.value = (ImageSelect)parameter.getValue();
        // GUI
        this.imgView = new ImageView(this.value.getValue());
        this.imgView.setFitWidth(128);
        this.imgView.setFitHeight(128);
        this.imgView.setPreserveRatio(true);
        this.imgView.setOnMousePressed(hClicked);
        this.imgView.setOnMouseEntered(hEntered);
        this.imgView.setOnMouseExited(hExited);
        this.getChildren().add(imgView);
    }
}
