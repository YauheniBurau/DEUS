package core.application.gui.workflowFxComponent.bean;

import core.application.gui.workflowFxComponent.param.FileSelect;

import java.lang.reflect.InvocationTargetException;

public class BeanFactory {

    /**
     * return BeanEmpty if not known Bean data
     * @param cls
     * @return
     */
    public static IBean newFromValueClass(Class<?> cls){
        IBean bean = new BeanEmpty();
        if(int.class.equals(cls)) {
            bean = new BeanBase<Integer>();
            bean.setValue(234);
        }else if(double.class.equals(cls)) {
            bean = new BeanDouble(0.0);
        }else if(String.class.equals(cls)) {
            bean = new BeanString("");
        }else if(void.class.equals(cls)){
            bean = new BeanEmpty();
        }else if(FileSelect.class.equals(cls)){
            bean = new BeanFileSelect();
        } else{
            //throw new RuntimeException("Bean class of IBean for current type value - is not implemented");
        }
        return bean;
    }

    /**
     * return BeanEmpty if not known Bean data
     * @param cls
     * @return
     */
    public static IBean newFromBeanClass(Class<?> cls){
        IBean bean = null;
        try {
            bean = (IBean)cls.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return bean;
    }


}
