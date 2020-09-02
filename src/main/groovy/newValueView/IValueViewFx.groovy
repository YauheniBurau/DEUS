package newValueView

trait IValueViewFx<T>{
    T value

    /**
     * used only one time when create ViewFX firstTime
     */
    void init(T value){
        this.value = value
        this.updateView()
    }

    abstract void updateView()

    abstract void updateToModel()

}