package core.application.gui.graphFxComponent.odb;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;

public class EdgeDbFactory {
    private EdgeDbBuilder builder;

    public EdgeDbFactory(EdgeDbBuilder builder) {
        this.builder = builder;
    }

    public OEdge newELink(OVertex vLink, OVertex vOrigin){
        return builder.withNew()
                .withV1_V2_Class(vLink, vOrigin, GraphDb.oClassELink)
                .build();
    }

    public OEdge newEParent(OVertex vParent, OVertex vChild){
        return builder.withNew()
                .withV1_V2_Class(vParent, vChild, GraphDb.oClassEParent)
                .build();
    }

    public OEdge newEPrevNext(OVertex vStart, OVertex vEnd){
        return builder.withNew()
                .withV1_V2_Class(vStart, vEnd, GraphDb.oClassEPrevNext)
                .build();
    }


}
