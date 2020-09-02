package core.application.gui.workflowFxComponent.bean;

public class BeanEmpty implements IBean<Object> {
    private Object value;

    public BeanEmpty() {
        this.value = null;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}
