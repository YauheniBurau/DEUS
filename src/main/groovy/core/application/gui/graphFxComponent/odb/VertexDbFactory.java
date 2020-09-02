package core.application.gui.graphFxComponent.odb;

import com.orientechnologies.orient.core.record.OVertex;

public class VertexDbFactory {
    private VertexDbBuilder builder;

    public VertexDbFactory(VertexDbBuilder builder) {
        this.builder = builder;
    }

    public OVertex newVDataChar(String ch){
        return builder.withNew()
                .withClass(GraphDb.oClassVDataChar)
                .withProperty( GraphDb.PROPERTY_VALUE, ch)
                .build();
    }

    public OVertex newVDataSound(){
        return builder.withNew()
                .withClass(GraphDb.oClassVDataSound)
                .build();
    }

    public OVertex newVDataVisual(){
        return builder.withNew()
                .withClass(GraphDb.oClassVDataVisual)
                .build();
    }

    public OVertex newVLink(){
        return builder.withNew()
                .withClass(GraphDb.oClassVLink)
                .build();
    }

    public OVertex newVParent(){
        return builder.withNew()
                .withClass(GraphDb.oClassVParent)
                .build();
    }

}
