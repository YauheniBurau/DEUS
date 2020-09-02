package core.application.gui.workflowFxComponent.propertyEditors;

import core.application.gui.factoryFx.PropertySheetFxFactory;
import core.application.gui.workflowFxComponent.bean.BeanFactory;
import core.application.gui.workflowFxComponent.bean.IBean;
import core.application.gui.workflowFxComponent.reflection.Reflection;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.SearchableComboBox;
import org.controlsfx.property.BeanPropertyUtils;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;

import java.util.Collection;

public class BeanEditor extends BasePropertyEditor<IBean> {
    private SearchableComboBox<Package> fieldPackages;
    private SearchableComboBox<Class> fieldClasses;
    private PropertySheet propertySheet;

    public BeanEditor(PropertySheet.Item parameter) {
        this.value = (IBean)parameter.getValue();
        this.fieldPackages = new SearchableComboBox<>();
        this.fieldClasses = new SearchableComboBox<>();
        this.propertySheet = PropertySheetFxFactory.newPropertySheet(true, false, false,
                new PropertyEditorCallback(), this.value);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(this.fieldPackages, this.fieldClasses, this.propertySheet);
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
            if( newVal != null && this.value.getClass()!=this.fieldClasses.getValue() ){
                this.setValue(BeanFactory.newFromBeanClass(this.fieldClasses.getValue()));
                this.propertySheet.getItems().clear();
                this.propertySheet.getItems().addAll(BeanPropertyUtils.getProperties(this.getValue()));
                parameter.setValue(this.getValue());
            }
        });
        // init values in Fx fields
        this.fieldPackages.setValue(this.value.getClass().getPackage());
        this.fieldClasses.setValue(this.value.getClass());
    }

}
