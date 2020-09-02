package core.application.gui.builderFx;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class StageFxBuilder extends AbstractBaseFxBuilder<Stage> {

    public StageFxBuilder() {
        this.value = new Stage();
    }

    public StageFxBuilder(Stage stage) {
        this.value = stage;
    }

    public StageFxBuilder withTitle(String title){
        this.value.setTitle(title);
        return this;
    }

    public StageFxBuilder withInitStyle(StageStyle stageStyle){
        if(this.value.getStyle()==null) {
            this.value.initStyle(stageStyle);
        }
        return this;
    }

    public StageFxBuilder withAlwaysOnTop(boolean value){
        this.value.setAlwaysOnTop(value);
        return this;
    }

    public StageFxBuilder withScene(Scene scene){
        this.value.setScene(scene);
        // this.getScene().getStylesheets().add(getClass().getResource("core.application.AI_Application.css").getFile() );
        // this.getScene().getStylesheets().add(getClass().getResource("core.application.AI_Application.css").toExternalForm());
        return this;
    }

    public StageFxBuilder withModality(Modality initModality){
        this.value.initModality(initModality);
        return this;
    }

    public StageFxBuilder withOwner(Stage owner){
        this.value.initOwner(owner);
        return this;
    }

    public StageFxBuilder withOnCloseRequest(EventHandler<WindowEvent> handler){
        this.value.setOnCloseRequest(handler);
        return this;
    }

    public StageFxBuilder setX(double value){
        this.value.setX(value);
        return this;
    }

    public StageFxBuilder setY(double value){
        this.value.setY(value);
        return this;
    }

    public void show(){
        this.value.show();
    }

}
