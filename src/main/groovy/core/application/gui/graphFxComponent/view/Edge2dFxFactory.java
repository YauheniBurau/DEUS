package core.application.gui.graphFxComponent.view;

import com.orientechnologies.orient.core.record.OEdge;
import core.application.gui.graphFxComponent.odb.GraphDb;
import javafx.scene.paint.Color;

public class Edge2dFxFactory {

    public static Edge2dFx newELink(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("L")
                .withCurveFill(Color.YELLOW)
                .withTextFill(Color.YELLOW)
                .build();
    }

    public static Edge2dFx newEParent(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("P")
                .withCurveFill(Color.RED)
                .withTextFill(Color.RED)
                .build();
    }

    public static Edge2dFx newEPrevNext(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("P->N")
                .withCurveFill(Color.BLUE)
                .withTextFill(Color.BLUE)
                .build();
    }

    public static Edge2dFx mapEdge2dFx(Vertex2dFx v1, Vertex2dFx v2, OEdge e) {
        Edge2dFx e2dFx;
        String className = e.getSchemaType().get().getName();
        if(className.equals(GraphDb.OCLASS_E_LINK)) {
            e2dFx = newELink(v1, v2);
        }else if(className.equals(GraphDb.OCLASS_E_PARENT)) {
            e2dFx = newEParent(v1, v2);
        }else if(className.equals(GraphDb.OCLASS_E_PREV_NEXT)) {
            e2dFx = newEPrevNext(v1, v2);
        }else{
            throw new RuntimeException("Not implemented mapping for that OEdge SchemaType");
        }
        return e2dFx;
    }

}
