package core.application.gui.workflowFxComponent.bean;

public class BeanBase<T> implements IBean<T> {
    private T value;

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

}
