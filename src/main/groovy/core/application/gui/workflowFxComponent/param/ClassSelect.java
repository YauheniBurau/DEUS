package core.application.gui.workflowFxComponent.param;

public class ClassSelect {
    private Class<?> value;

    public ClassSelect(Class<?> value) {
        this.value = value;
    }

    public Class<?> getValue() {
        return value;
    }

    public void setValue(Class<?> value) {
        this.value = value;
    }
}
