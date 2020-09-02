package core.application.gui.workflowFxComponent.bean;

import groovy.beans.Bindable;

import java.io.Serializable;

@Bindable
public interface IBean<T> extends Serializable {
    T getValue();
    void setValue(T value);
}
