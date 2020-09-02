package core.application.gui.workflowFxComponent.bean;

public class BeanDouble  implements IBean<Double> {
    private double value;

    public BeanDouble() {
        this.value = 0.0;
    }

    public BeanDouble(double value) {
        this.value = value;
    }

    @Override
    public Double getValue () {
        return value;
    }

    @Override
    public void setValue (Double value){
        this.value = value;
    }
}