package core.application.gui.graphFxComponent.view;

import com.orientechnologies.orient.core.record.OVertex;
import core.application.gui.graphFxComponent.odb.GraphDb;
import javafx.scene.paint.Color;

public class Vertex2dFxFactory {

    public static Vertex2dFx newVDataChar(String ch){
        return new Vertex2dFxBuilder()
                .withText("'"+ch+"'")
                .withCircleFill(Color.ORANGERED)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVDataSound(){
        return new Vertex2dFxBuilder()
                .withText("Sou")
                .withCircleFill(Color.ORANGE)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVDataVisual(){
        return new Vertex2dFxBuilder()
                .withText("Vis")
                .withCircleFill(Color.DARKORANGE)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVLink(){
        return new Vertex2dFxBuilder()
                .withText("L")
                .withCircleFill(Color.PINK)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVParent(){
        return new Vertex2dFxBuilder()
                .withText("P")
                .withCircleFill(Color.BLUE)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx mapVertex2dFx(OVertex v) {
        Vertex2dFx v2dFx;
        String className = v.getSchemaType().get().getName();
        if(className.equals(GraphDb.OCLASS_V_DATA_CHAR)) {
            v2dFx = newVDataChar(v.getProperty(GraphDb.PROPERTY_VALUE));
        }else if(className.equals(GraphDb.OCLASS_V_DATA_SOUND)) {
            v2dFx = newVDataSound();
        }else if(className.equals(GraphDb.OCLASS_V_DATA_VISUAL)) {
            v2dFx = newVDataVisual();
        }else if(className.equals(GraphDb.OCLASS_V_LINK)) {
            v2dFx = newVLink();
        }else if(className.equals(GraphDb.OCLASS_V_PARENT)) {
            v2dFx = newVParent();
        }else{
            throw new RuntimeException("Not implemented mapping for that OVertex SchemaType");
        }
        return v2dFx;
    }


}
