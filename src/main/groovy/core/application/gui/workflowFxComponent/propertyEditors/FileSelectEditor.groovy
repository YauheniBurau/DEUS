package core.application.gui.workflowFxComponent.propertyEditors

import core.application.gui.factoryFx.ButtonFxFactory
import core.application.gui.factoryFx.FileChooserFxFactory
import core.application.gui.workflowFxComponent.param.FileSelect
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.control.Tooltip
import javafx.stage.FileChooser
import org.controlsfx.control.PropertySheet

class FileSelectEditor extends BasePropertyEditor<FileSelect> {
    private TextField field;

    FileSelectEditor(PropertySheet.Item parameter) {
        this.value = (FileSelect)parameter.getValue();
        // GUI
        this.field = new TextField();
        this.field.editableProperty().set(false);
        this.field.setTooltip(new Tooltip(this.value.fileChooserTitle));
        this.field.setText(this.value.file.getName());
        Button btn = ButtonFxFactory.create("...", hBtn);
        this.getChildren().addAll(this.field, btn);
    }

    EventHandler<ActionEvent> hBtn = (e) -> {
        FileChooser fc = FileChooserFxFactory.createFileChooser(value)
        File file = fc.showOpenDialog(null)
        if (file != null){
            this.value.file = file
            this.field.text = file.getName()
        }
    }
}