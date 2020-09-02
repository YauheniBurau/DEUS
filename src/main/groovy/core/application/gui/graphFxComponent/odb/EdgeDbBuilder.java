package core.application.gui.graphFxComponent.odb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;

public class EdgeDbBuilder {
    private OEdge e = null;
    private ODatabaseSession dbSession;

    public EdgeDbBuilder(ODatabaseSession dbSession) {
        this.dbSession = dbSession;
    }

    public EdgeDbBuilder withNew() {
        this.e = null;
        return this;
    }

    public EdgeDbBuilder withV1_V2_Class(OVertex v1, OVertex v2, OClass oClass){
        this.e = null;
        if(v1!=null && v2 != null) {
            this.e = this.dbSession.newEdge(v1, v2, oClass);
        }
        return this;
    }

    public EdgeDbBuilder withProperty(String name, Object value) {
        this.e.setProperty(name, value);

        return this;
    }

    public OEdge build(){
        return this.e;
    }

}
