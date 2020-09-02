package core.application.gui.workflowFxComponent.bean;

public class BeanInt implements IBean<Integer> {
    private int value;

    public BeanInt() {
        this.value = 0;
    }

    public BeanInt(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
