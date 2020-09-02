package core.application.gui.workflowFxComponent.bean;

public class BeanString implements IBean<String> {
    private String value;

    public BeanString() {
        this.value = "";
    }


    public BeanString(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
