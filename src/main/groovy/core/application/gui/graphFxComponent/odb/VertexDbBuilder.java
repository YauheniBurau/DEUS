package core.application.gui.graphFxComponent.odb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.record.OVertex;

public class VertexDbBuilder {
    private OVertex v = null;
    private ODatabaseSession dbSession;

    public VertexDbBuilder(ODatabaseSession dbSession) {
        this.dbSession = dbSession;
    }

    public VertexDbBuilder withNew() {
        this.v = null;
        return this;
    }

    public VertexDbBuilder withClass(OClass oClass){
        this.v = this.dbSession.newVertex(oClass);
        return this;
    }

    public VertexDbBuilder withProperty(String name, Object value) {
        this.v.setProperty(name, value);
        return this;
    }

    public OVertex build(){
        return this.v;
    }

}
