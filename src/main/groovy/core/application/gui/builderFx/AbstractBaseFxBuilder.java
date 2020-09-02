package core.application.gui.builderFx;

public abstract class AbstractBaseFxBuilder<T> implements IFxBuilder<T> {
    protected T value;

    public T build(){
        return value;
    }

}
