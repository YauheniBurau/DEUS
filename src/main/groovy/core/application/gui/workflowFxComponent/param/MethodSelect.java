package core.application.gui.workflowFxComponent.param;

import java.lang.reflect.Method;

public class MethodSelect {
    private Method value;

    public MethodSelect(Method value) {
        this.value = value;
    }

    public Method getValue() {
        return value;
    }

    public void setValue(Method value) {
        this.value = value;
    }
}
