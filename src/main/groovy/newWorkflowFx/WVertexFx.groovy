package newWorkflowFx

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import org.controlsfx.control.SearchableComboBox
import java.lang.reflect.Constructor
import java.lang.reflect.Method

class WVertexFx extends StackPane {
    private Button closeBtn = new WVertexCloseBtnFx()
    private Button invokeBtn = new WVertexInvokeBtnFx()
    private Label title = new Label("")
    private TitledPane titledPane = new TitledPane()
    private SearchableComboBox<Object> methodsComboBox = new SearchableComboBox<>()
    private WVertexContactFx inputContactFx
    private WVertexContactFx outputContactFx
    private VBox inputContactsVBox = new VBox()
    private VBox outputContactsVBox = new VBox()
    private WVertexContactFx[] inMethodContacts
    private WVertexContactFx[] outMethodContacts

    WVertexFx(WVertexContactFx inputContactClassOrObjectFx) {
        this.inputContactFx = inputContactClassOrObjectFx
        this.outputContactFx = new WVertexContactFx(false, Object.class)
        this.methodsComboBox.setMaxWidth(100)
        // add titledPane into stackPane
        this.getChildren().add(this.titledPane)
        this.setAlignment(this.titledPane, Pos.TOP_CENTER)
        // add title into stackPane
        this.getChildren().add(this.title)
        this.setAlignment(this.title, Pos.TOP_CENTER)
        this.setMargin(this.title, new Insets(5, 60, 5, 20) )
        // add HeaderCloseButton into StackPane
        HBox headerCloseBtnBox = new HBox(5)
        headerCloseBtnBox.setMaxSize(0, 0)
        headerCloseBtnBox.getChildren().addAll(this.closeBtn)
        this.getChildren().add(headerCloseBtnBox)
        this.setAlignment(headerCloseBtnBox, Pos.TOP_RIGHT)
        this.setMargin(headerCloseBtnBox, new Insets(1, 1, 1, 1) )
        // add MethodSelectBox
        HBox addMethodOrConstructorBox = new HBox(this.inputContactFx, this.methodsComboBox, this.outputContactFx)
        this.inputContactFx.setAlignment(Pos.CENTER)
        this.methodsComboBox.setOnAction(hMethodSelected)
        // add all into TitledPane
        this.titledPane.setContent( new VBox(
                addMethodOrConstructorBox,
                new HBox(this.inputContactsVBox, this.outputContactsVBox),
                this.invokeBtn)
        )
        // resizable and draggable
        MakeWVertexFxResizable.makeResizable(this)
        MakeWVertexFxDruggable.makeDruggable(this)

    }

    void initWVertexContactsFx(Object selectedMethod) {
        Class<?>[] paramsType
        Class<?> returnType
        if(selectedMethod.getClass()==Method.class){
            paramsType = selectedMethod.getParameterTypes()
            returnType = selectedMethod.getReturnType()
        }
        if(selectedMethod.getClass()==Constructor.class){
            paramsType = selectedMethod.getParameterTypes()
            returnType = null
        }
        this.inMethodContacts = paramsType.collect {
            new WVertexContactFx(true, it)
        }
        if( returnType!=null && returnType!=void.class){
            this.outMethodContacts = [returnType].collect { new WVertexContactFx(false, it) }
        }
        this.inputContactsVBox.getChildren().clear()
        if(this.inMethodContacts!=null ) this.inputContactsVBox.getChildren().addAll(this.inMethodContacts)
        this.outputContactsVBox.getChildren().clear()
        if(this.outMethodContacts!=null ) this.outputContactsVBox.getChildren().addAll(this.outMethodContacts)
    }

    void setLayoutXY(double posX, double posY){
        this.setLayoutX(posX)
        this.setLayoutY(posY)
    }

    Label getTitle(){
        return this.title
    }

    void setTitleText(String value){
        this.title.setText(value)
    }

    def getInputValue(){
        return this.inputContactFx.getContactValue()
    }

    void setInputValue(def value){
        this.inputContactFx.setContactValue(value)
        Object v = this.getInputValue()
        // update methodsComboBox
        if(v.getClass() == Class.class){
            this.methodsComboBox.getItems().addAll(((Class)v).getDeclaredConstructors())
        }else {
            this.methodsComboBox.getItems().addAll(v.getClass().getDeclaredMethods())
        }

}

    def getOutputValue(){
        return this.outputContactFx.getContactValue()
    }

    void setOnActionInvokeBtn(EventHandler<ActionEvent> handler){
        this.invokeBtn.setOnAction(handler)
    }

    void setOnActionCloseVertexBtn(EventHandler<ActionEvent> e){
        this.closeBtn.setOnAction(e)
    }

    EventHandler<ActionEvent> hMethodSelected = e ->{
        Object m = this.methodsComboBox.getValue()
        if(m.getClass() == Method.class){
            this.setTitleText( this.inputValue.getClass().getSimpleName() + "::" + ((Method)m).name )
        }else if(m.getClass() == Constructor.class){
            this.setTitleText( ((Constructor)m).name )
        }
        this.initWVertexContactsFx(this.methodsComboBox.getValue())
    }

    static WVertexFx create(double x, double y, Class<?> clazz){
        WVertexContactFx vertexInContactFx = new WVertexContactFx(true, Class.class)
        WVertexFx v = new WVertexFx(vertexInContactFx)
        v.setTitleText("Empty")
        v.setLayoutX(x)
        v.setLayoutY(y)
        v.setInputValue(clazz)
        return v
    }

    static WVertexFx create(double x, double y, Object obj){
        WVertexContactFx vertexInContactFx = new WVertexContactFx(true, obj.getClass())
        WVertexFx v = new WVertexFx(vertexInContactFx)
        v.setTitleText("Empty")
        v.setLayoutX(x)
        v.setLayoutY(y)
        v.setInputValue(obj)
        return v
    }

}