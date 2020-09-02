package core.application.gui.factoryFx;

import javafx.util.Callback;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanPropertyUtils;
import org.controlsfx.property.editor.PropertyEditor;

public class PropertySheetFxFactory {

    public static PropertySheet newPropertySheet(boolean isVisible,
                                                 boolean isSwitcherVisible,
                                                 boolean isSearchBoxVisible,
                                                 Callback<PropertySheet.Item, PropertyEditor<?>> factory,
                                                 Object bean) {
        PropertySheet ps = new PropertySheet();
        ps.setVisible(isVisible);
        ps.getItems().clear();
        ps.setModeSwitcherVisible(isSwitcherVisible);
        ps.setSearchBoxVisible(isSearchBoxVisible);
        if(factory!=null){ ps.setPropertyEditorFactory(factory); }
        if(bean != null){ ps.getItems().addAll(BeanPropertyUtils.getProperties(bean)); }
        return ps;
    }
}