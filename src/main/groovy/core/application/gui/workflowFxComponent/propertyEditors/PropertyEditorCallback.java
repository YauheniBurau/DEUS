package core.application.gui.workflowFxComponent.propertyEditors;

import core.application.gui.workflowFxComponent.bean.IBean;
import core.application.gui.workflowFxComponent.param.ClassSelect;
import core.application.gui.workflowFxComponent.param.FileSelect;
import core.application.gui.workflowFxComponent.param.ImageSelect;
import core.application.gui.workflowFxComponent.param.MethodSelect;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.Editors;
import org.controlsfx.property.editor.PropertyEditor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public class PropertyEditorCallback implements Callback<PropertySheet.Item, PropertyEditor<?>> {
    private static Class<?>[] numericTypes;

    public PropertyEditor<?> call(PropertySheet.Item item) {
        Class<?> type = item.getType();
        if (item.getPropertyEditorClass().isPresent()) {
            Optional<PropertyEditor<?>> ed = Editors.createCustomEditor(item);
            if (ed.isPresent()) {
                return (PropertyEditor)ed.get();
            }
        }

        //==========================ADD YOURS PERSONAL RETURN EDITORS===================================================
        if(type == FileSelect.class){
            return new FileSelectEditor(item);
        }
        if(type == MethodSelect.class) {
            return new MethodSelectEditor(item);
        }
        if(type == ImageSelect.class) {
            return new ImageSelectEditor(item);
        }
        if(type == ClassSelect.class) {
            return new ClassSelectEditor(item);
        }
        if(type == IBean.class) {
            return new BeanEditor(item);
        }

        //==============================================================================================================
        if (type == String.class) {
            return Editors.createTextEditor(item);
        } else if (isNumber(type)) {
            return Editors.createNumericEditor(item);
        } else if (type != Boolean.TYPE && type != Boolean.class) {
            if (type == LocalDate.class) {
                return Editors.createDateEditor(item);
            } else if (type != Color.class && type != Paint.class) {
                if (type != null && type.isEnum()) {
                    return Editors.createChoiceEditor(item, Arrays.asList(type.getEnumConstants()));
                } else {
                    return type == Font.class ? Editors.createFontEditor(item) : null;
                }
            } else {
                return Editors.createColorEditor(item);
            }
        } else {
            return Editors.createCheckEditor(item);
        }
    }

    private static boolean isNumber(Class<?> type) {
        if (type == null) {
            return false;
        } else {
            Class[] var1 = numericTypes;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Class<?> cls = var1[var3];
                if (type == cls) {
                    return true;
                }
            }

            return false;
        }
    }

    static {
        numericTypes = new Class[]{Byte.TYPE, Byte.class, Short.TYPE, Short.class, Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, BigInteger.class, BigDecimal.class};
    }
}

