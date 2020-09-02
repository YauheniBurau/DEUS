package core.application.gui.graphFxComponent.odb;

import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.ODirection;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.ORecord;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import core.application.gui.graphFxComponent.model.GraphModel;

import java.util.Optional;

public class GraphDb {
    public static String OCLASS_V_DATA_CHAR = "V_DATA_CHAR";
    public static String OCLASS_V_DATA_SOUND = "V_DATA_SOUND";
    public static String OCLASS_V_DATA_VISUAL = "V_DATA_VISUAL";
    public static String OCLASS_V_LINK = "V_LINK";
    public static String OCLASS_V_PARENT = "V_PARENT";

    public static String OCLASS_E_PREV_NEXT = "E_PREV_NEXT";
    public static String OCLASS_E_LINK = "E_LINK";
    public static String OCLASS_E_PARENT = "E_PARENT";

    public static String PROPERTY_VALUE = "VALUE";
    public static String PROPERTY_LINK = "LINK";
    public static String PROPERTY_ID = "ID";

    public static OClass oClassVDataChar = null;
    public static OClass oClassVDataSound = null;
    public static OClass oClassVDataVisual = null;
    public static OClass oClassVLink = null;
    public static OClass oClassVParent = null;

    public static OClass oClassEPrevNext = null;
    public static OClass oClassELink = null;
    public static OClass oClassEParent = null;

    private String URL = "";
    private String DB_NAME = "";
    private String USER = "";
    private String PASSWORD = "";

    private OrientDB orientDB;
    private ODatabasePool dbPool;
    private ODatabaseSession dbSession;
    private VertexDbFactory vertexFactory;
    private EdgeDbFactory edgeFactory;

    //==================================================================================================================
    private void init_Class_V_DATA_CHAR(ODatabaseSession db) {
        if (oClassVDataChar == null) {
            oClassVDataChar = db.getClass(OCLASS_V_DATA_CHAR);
            if (oClassVDataChar == null) {
                oClassVDataChar = db.createVertexClass(OCLASS_V_DATA_CHAR);
            }
            if (oClassVDataChar.getProperty(PROPERTY_VALUE) == null) {
                oClassVDataChar.createProperty(PROPERTY_VALUE, OType.STRING)
                        .setMin("1").setMax("1").setMandatory(true).setReadonly(true);
            }
        }
    }

    private void init_Class_V_DATA_SOUND(ODatabaseSession db) {
        if (oClassVDataSound == null) {
            oClassVDataSound = db.getClass(OCLASS_V_DATA_SOUND);
            if (oClassVDataSound == null) {
                oClassVDataSound = db.createVertexClass(OCLASS_V_DATA_SOUND);
            }
        }
    }

    private void init_Class_V_DATA_VISUAL(ODatabaseSession db) {
        if (oClassVDataVisual == null) {
            oClassVDataVisual = db.getClass(OCLASS_V_DATA_VISUAL);
            if (oClassVDataVisual == null) {
                oClassVDataVisual = db.createVertexClass(OCLASS_V_DATA_VISUAL);
            }
        }
    }

    private void init_Class_V_LINK(ODatabaseSession db) {
        if (oClassVLink == null) {
            oClassVLink = db.getClass(OCLASS_V_LINK);
            if (oClassVLink == null) {
                oClassVLink = db.createVertexClass(OCLASS_V_LINK);
            }
        }
    }

    private void init_Class_V_PARENT(ODatabaseSession db) {
        if (oClassVParent == null) {
            oClassVParent = db.getClass(OCLASS_V_PARENT);
            if (oClassVParent == null) {
                oClassVParent = db.createVertexClass(OCLASS_V_PARENT);
            }
        }
    }

    private void init_Class_E_PREV_NEXT(ODatabaseSession db) {
        if (oClassEPrevNext == null) {
            oClassEPrevNext = db.getClass(OCLASS_E_PREV_NEXT);
            if (oClassEPrevNext == null) {
                oClassEPrevNext = db.createEdgeClass(OCLASS_E_PREV_NEXT);
            }
        }
    }

    private void init_Class_E_PARENT(ODatabaseSession db) {
        if (oClassEParent == null) {
            oClassEParent = db.getClass(OCLASS_E_PARENT);
            if (oClassEParent == null) {
                oClassEParent = db.createEdgeClass(OCLASS_E_PARENT);
            }
        }
    }

    private void init_Class_E_LINK(ODatabaseSession db) {
        if (oClassELink == null) {
            oClassELink = db.getClass(OCLASS_E_LINK);
            if (oClassELink == null) {
                oClassELink = db.createEdgeClass(OCLASS_E_LINK);
            }
        }
    }

    //==================================================================================================================
    public GraphDb(String url, String dbName, String user, String password) {
        this.URL = url;
        this.DB_NAME = dbName;
        this.USER = user;
        this.PASSWORD = password;
    }

    //==================================================================================================================
    public void disconnect() {
        this.dbSession.close();
//        this.dbPool.close();
        orientDB.close();
    }

    public void connect() {
        OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();
        this.orientDB = new OrientDB(URL, dbConfig);
        this.dbSession = this.orientDB.open(DB_NAME, USER, PASSWORD);
        this.vertexFactory = new VertexDbFactory(new VertexDbBuilder(this.dbSession));
        this.edgeFactory = new EdgeDbFactory(new EdgeDbBuilder(this.dbSession));
        // INIT ALL OCLASS VERTEXES
        this.init_Class_V_DATA_CHAR(this.dbSession);
        this.init_Class_V_DATA_SOUND(this.dbSession);
        this.init_Class_V_DATA_VISUAL(this.dbSession);
        this.init_Class_V_PARENT(this.dbSession);
        this.init_Class_V_LINK(this.dbSession);
        // INIT ALL OCLASS EDGES
        this.init_Class_E_LINK(this.dbSession);
        this.init_Class_E_PARENT(this.dbSession);
        this.init_Class_E_PREV_NEXT(this.dbSession);
    }

    public void beginTx(){
        this.dbSession.begin();
    }

    public void commitTx(){
        this.dbSession.commit();
    }

    //==================================================================================================================
    /**
     * save instantly OVertex or OEdge into DB
     * @param record
     */
    public void save(ORecord record){
        if(record!=null) {
            this.dbSession.save(record);
        }
    }

    /**
     * delete record from DB
     * @param record
     */
    public void delete(ORecord record){
        if(record!=null) {
            this.dbSession.delete(record);
        }
    }

    /**
     * delete from DB all records of OEdge of oEdgeClass
     * @param oEdgeClass
     */
    public void deleteAllEdges(OClass oEdgeClass){
        String statement = "delete edge " + oEdgeClass.getName();
        OResultSet rs = this.dbSession.command(statement);
        rs.close();
    }

    /**
     * delete from DB all records of OVertex of oVertexClass
     * @param oVertexClass
     */
    public void deleteAllVertexes(OClass oVertexClass){
        String statement = "DELETE VERTEX " + oVertexClass.getName();
        OResultSet rs = this.dbSession.command(statement);
        rs.close();
    }

    /**
     * select from V_DATA_CHAR where PROPERTY_VALUE = value
     * @param value
     * @return
     */
    public OVertex selectVDataCharByValue(String value){
        String statement = "SELECT FROM ? WHERE "+ PROPERTY_VALUE +" = ?";
        OResultSet rs = this.dbSession.query(statement, OCLASS_V_DATA_CHAR, value);
        OVertex v = null;
        while(rs.hasNext()){
            OResult row = rs.next();
            Optional<OVertex> opt = row.getVertex();
            v = opt.get();
        }
        rs.close();
        return v;
    }

    /**
     * return OVertex of type OClass - VParent
     * @param str
     * @return
     */
    public OVertex strToGraph(String str){
        OVertex vParent  = vertexFactory.newVParent();  this.save(vParent);
        OVertex vDataChar;
        OVertex vL_Last = null, vL_New = null;
        OEdge eParent = null, eLink = null, ePrevNext = null;
        char[] ascii = str.toCharArray();
        for (char ch: ascii) {
            vDataChar = this.selectVDataCharByValue( String.valueOf(ch) );
            if( vDataChar==null ){
                vDataChar = vertexFactory.newVDataChar( String.valueOf(ch) );
                this.save(vDataChar);
            }
            vL_New = vertexFactory.newVLink(); this.save(vL_New);
            eLink = edgeFactory.newELink(vL_New, vDataChar); this.save(eLink);
            eParent = edgeFactory.newEParent(vParent, vL_New); this.save(eParent);
            ePrevNext = edgeFactory.newEPrevNext(vL_Last, vL_New); this.save(ePrevNext);
            vL_Last = vL_New;
        }
        return vParent;
    }

    /**
     * select all "Vertexes" from Vertex(Typs:V_PARENT) and all edges connecting all that "Vertexes"
     * @param vParent
     * @return
     */
    public GraphModel selectAllChildrenWithParent(OVertex vParent){
        GraphModel gM = new GraphModel();
        Iterable<OVertex> itV = vParent.getVertices(ODirection.OUT, GraphDb.OCLASS_E_PARENT);
        // add vertexes
        gM.addLoadedVertex(vParent);
        for (OVertex v: itV) {
            gM.addLoadedVertex(v);
        }
        // add edges from Vertex Parent
        Iterable<OEdge> itE = vParent.getEdges(ODirection.OUT, GraphDb.OCLASS_E_PARENT);
        for (OEdge e: itE) {
            gM.addLoadedEdge(e);
        }
        // add edges between child Vertexes
        itV = vParent.getVertices(ODirection.OUT, GraphDb.OCLASS_E_PARENT);
        for (OVertex v: itV) {
            itE = v.getEdges(ODirection.BOTH, GraphDb.OCLASS_E_PREV_NEXT);
            for(OEdge e: itE){
                gM.addLoadedEdge(e);
            }
        }
        return gM;
    }

    //==================================================================================================================
    /**
     * compare OVertex Class SchemaType
     * @param v1
     * @param v2
     * @return
     */
    private static boolean CompareByClass(OVertex v1, OVertex v2){
        if( v1.getSchemaType().get() == v2.getSchemaType().get() ){ return true; }
        else return false;
    }



}

// TODO: remove later

// "remote:localhost", "ai", "root", "12345678"
//oClassClusterDataChar.createIndex(UID_CLUSTER_DATA_CHAR, OClass.INDEX_TYPE.UNIQUE, PROPERTY_VALUE);