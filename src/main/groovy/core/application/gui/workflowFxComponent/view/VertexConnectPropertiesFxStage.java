package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.ButtonFxFactory;
import core.application.gui.factoryFx.SceneFxFactory;
import core.application.gui.workflowFxComponent.propertyEditors.PropertyEditorCallback;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanPropertyUtils;

public class VertexConnectPropertiesFxStage extends Stage {
    private VertexConnect2dFx c2dFx;
    private Pane root;
    private PropertySheet propertySheet;
    private Button btnClose;
    private Button btnApply;

    public VertexConnectPropertiesFxStage(Stage owner, VertexConnect2dFx c2dFx) {
        this.c2dFx = c2dFx;
        StageFxBuilder stg = new StageFxBuilder(this);
        this.root = new Pane();
        Scene scene = SceneFxFactory.create(root, 480, 320);
        stg.withScene(scene).withTitle("VertexConnect properties:"+c2dFx.getModel().getLabel())
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        btnClose = ButtonFxFactory.create("close", e-> StageController.hideStage(this) );
        btnApply = ButtonFxFactory.create("apply", e->{this.c2dFx.updateFromModel();} );
        this.propertySheet = new PropertySheet();
        propertySheet.setPropertyEditorFactory(new PropertyEditorCallback());
        this.propertySheet.getItems().addAll(BeanPropertyUtils.getProperties(this.c2dFx.getModel()));
        // add to root
        HBox boxButtons = new HBox(btnClose, btnApply);
        VBox boxAll = new VBox(propertySheet, boxButtons);
        this.root.getChildren().add(boxAll);
    }

}
