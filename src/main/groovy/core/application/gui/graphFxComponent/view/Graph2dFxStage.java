package core.application.gui.graphFxComponent.view;

import com.orientechnologies.orient.core.record.OVertex;
import core.application.controller.StageController;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.BorderPaneFxFactory;
import core.application.gui.factoryFx.SceneFxFactory;
import core.application.gui.graphFxComponent.binding.GraphFacade;
import core.application.gui.graphFxComponent.model.GraphModel;
import core.application.gui.graphFxComponent.odb.GraphDb;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Graph2dFxStage extends Stage {
    private GraphFacade graphFacade = null;

    public Graph2dFxStage(Stage owner, GraphDb graphDb) {
        Graph2dFx graph2dFx = new Graph2dFx();
        GraphModel graphModel = new GraphModel();
        this.graphFacade = new GraphFacade(graph2dFx, graphModel, graphDb);
        StageFxBuilder stg = new StageFxBuilder(this);
        BorderPane root = BorderPaneFxFactory.create();
        Scene scene = SceneFxFactory.create(root, 1024, 640);
        stg.withScene(scene).withTitle("Utility1 instruments")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(true)
                .withOwner(owner)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        root.getChildren().add(graph2dFx);
        graph2dFx.setTranslateX(520);
        graph2dFx.setTranslateY(340);
        stg.build().setOnShowing(e -> initialize());
        stg.build().setOnShown(e -> System.out.println("Set on shown"));
        stg.build().setOnHiding(e -> System.out.println("Set on hiding"));
        stg.build().setOnHidden(e -> System.out.println("Set on hidden"));
        stg.build().setOnCloseRequest(e -> System.out.println("Set on CloseRequest"));
    }

    public void initialize(){
        System.out.println("setOnShowing");
        String str = "dogs and cats live together.____";
        OVertex v = graphFacade.db_strToGraphDb(str);
        GraphModel gM = graphFacade.db_selectAllChildrenWithParent(v);
        graphFacade.m_merge(gM);
        graphFacade.fx_mapGraphModelIntoGraph2dFx();
        graphFacade.fx_orderVertexes2dFxInSphere(400);
        //==============================================================================================================
    }

    public GraphFacade getGraphFacade() {
        return graphFacade;
    }
}
