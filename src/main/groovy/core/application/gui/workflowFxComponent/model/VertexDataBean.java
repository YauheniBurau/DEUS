package core.application.gui.workflowFxComponent.model;

import core.application.gui.workflowFxComponent.bean.BeanEmpty;
import core.application.gui.workflowFxComponent.bean.IBean;
import core.application.gui.workflowFxComponent.param.ClassSelect;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class VertexDataBean implements Serializable {
    private ClassSelect dataBeanClass;
    private IBean dataBeanValue;
    private VertexDataBeanTypeEnum dataBeanType;

    public VertexDataBean() {
        this.setDataBeanType(VertexDataBeanTypeEnum.EMPTY);
        this.setDataBeanClass(new ClassSelect(BeanEmpty.class));
    }

    public VertexDataBean(VertexDataBeanTypeEnum dataBeanType, ClassSelect dataBeanClass) {
        this.setDataBeanType(dataBeanType);
        this.setDataBeanClass(dataBeanClass);
    }

    public ClassSelect getDataBeanClass() {
        return dataBeanClass;
    }

    public void setDataBeanClass(ClassSelect dataBeanClass) {
        this.dataBeanClass = dataBeanClass;
        try {
            this.setDataBeanValue((IBean)dataBeanClass.getValue().getConstructor().newInstance());
        } catch (InstantiationException e) {
            throw new RuntimeException("InstantiationException");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("NoSuchMethodException");
        }

    }

    public IBean getDataBeanValue() {
        return this.dataBeanValue;
    }

    public void setDataBeanValue(IBean dataBeanValue) {
            this.dataBeanValue = dataBeanValue;
    }

    public VertexDataBeanTypeEnum getDataBeanType() {
        return dataBeanType;
    }

    public void setDataBeanType(VertexDataBeanTypeEnum dataBeanType) {
        this.dataBeanType = dataBeanType;
    }
}
