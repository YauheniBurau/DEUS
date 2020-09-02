package core.application.gui.workflowFxComponent.propertyEditors;

import core.application.gui.workflowFxComponent.param.ClassSelect;
import core.application.gui.workflowFxComponent.reflection.Reflection;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.SearchableComboBox;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;

import java.util.Collection;


public class ClassSelectEditor extends BasePropertyEditor<ClassSelect> {
    private SearchableComboBox<Package> fieldPackages;
    private SearchableComboBox<Class> fieldClasses;

    public ClassSelectEditor(PropertySheet.Item parameter) {
        this.value = (ClassSelect)parameter.getValue();
        this.fieldPackages = new SearchableComboBox<>();
        this.fieldClasses = new SearchableComboBox<>();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(this.fieldPackages, this.fieldClasses);
        this.getChildren().add(vbox);

        JarClassLoader jcl = JclContext.get();
        this.fieldPackages.setItems((FXCollections.observableArrayList(
                jcl.getParent().getDefinedPackages())));
        this.fieldPackages.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)->{
            if(newVal != null){
                Collection<Class> allClasses = null;
                try {
                    allClasses = Reflection.getClasses(fieldPackages.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.fieldClasses.setItems((FXCollections.observableArrayList(allClasses)));
                this.fieldClasses.commitValue();
            }
        });
        this.fieldClasses.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)->{
            if(newVal != null){
                this.getValue().setValue(this.fieldClasses.getValue());
            }
        });
        // init values in Fx fields
        this.fieldPackages.setValue(this.value.getValue().getPackage());
        this.fieldClasses.setValue(this.value.getValue());
    }
}

