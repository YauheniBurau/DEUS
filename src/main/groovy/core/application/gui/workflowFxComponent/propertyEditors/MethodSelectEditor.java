package core.application.gui.workflowFxComponent.propertyEditors;

import newGui.NotificationsFxFactory;
import core.application.gui.workflowFxComponent.param.MethodSelect;
import core.application.gui.workflowFxComponent.reflection.Reflection;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.SearchableComboBox;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;

import java.lang.reflect.Method;
import java.util.Collection;

public class MethodSelectEditor extends BasePropertyEditor<MethodSelect> {
    private SearchableComboBox<Package> fieldPackages;
    private SearchableComboBox<Class> fieldClasses;
    private SearchableComboBox<Method> fieldMethods;

    public MethodSelectEditor(PropertySheet.Item parameter) {
        this.value = (MethodSelect)parameter.getValue();
        this.fieldPackages = new SearchableComboBox<>();
        this.fieldClasses = new SearchableComboBox<>();
        this.fieldMethods = new SearchableComboBox<>();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(this.fieldPackages, this.fieldClasses, this.fieldMethods);
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
                    NotificationsFxFactory.showError("MethodEditor", "can't get classes from package", e);
                }
                this.fieldClasses.setItems((FXCollections.observableArrayList(allClasses)));
                this.fieldClasses.commitValue();
                this.fieldClasses.setValue(null);
            }
        });
        this.fieldClasses.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)->{
            if(newVal != null){
                Collection<Method> allMethods = null;
                try {
                    allMethods = Reflection.getClassStaticMethods(fieldClasses.getValue());
                } catch (Exception e) {
                    NotificationsFxFactory.showError("MethodEditor", "can't get all methods from class", e);
                }
                this.fieldMethods.setItems((FXCollections.observableArrayList(allMethods)));
                this.fieldMethods.commitValue();
                this.fieldMethods.setValue(null);
            }
        });
        this.fieldMethods.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)->{
            if(newVal != null && this.value.getClass()!=this.fieldClasses.getValue() ){
                this.getValue().setValue(this.fieldMethods.getValue());
            }
        });
        // init values in Fx fields
        this.fieldPackages.setValue(value.getClass().getPackage());
        this.fieldClasses.setValue(this.value.getClass());
        this.fieldMethods.setValue(this.value.getValue());
    }
}