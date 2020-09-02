package core.application.gui.workflowFxComponent.propertyEditors;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import org.controlsfx.property.editor.PropertyEditor;

public abstract class BasePropertyEditor<T> extends HBox implements PropertyEditor<T> {
    protected T value;

    @Override
    public Node getEditor() {
        return this;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T t) {
        this.value = t;
    }
}
