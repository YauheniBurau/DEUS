package core.old;

import com.orientechnologies.orient.core.db.*;

import java.util.Properties;

public class GraphODB{
    private static String URL = "url";
    private static String DB_NAME = "dbname";
    private static String USER = "user";
    private static String PASSWORD = "password";

    private Properties properties = new Properties();

    public Properties properties(){
        return this.properties;
    }

    private OrientDB orientDB;
    private ODatabasePool dbPool;
    private ODatabaseSession dbSession;

    public GraphODB(String url, String dbName, String user, String password) {
        this.properties().setProperty(GraphODB.URL, url);
        this.properties().setProperty(GraphODB.DB_NAME, dbName);
        this.properties().setProperty(GraphODB.USER, user);
        this.properties().setProperty(GraphODB.PASSWORD, password);
    }

    public void connect() {
        OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();
        this.orientDB = new OrientDB(this.properties().getProperty(GraphODB.URL), dbConfig);
        this.dbSession = this.orientDB.open(
                this.properties().getProperty(GraphODB.DB_NAME),
                this.properties().getProperty(GraphODB.USER),
                this.properties().getProperty(GraphODB.PASSWORD)
        );
//        String orientDBPath = this.properties().getProperty(GraphODB.URL)+ "/"+this.properties().getProperty(GraphODB.DB_NAME);
//        this.orientDB = new OrientDB(orientDBPath, dbConfig);
//        orientDB.createIfNotExists(orientDBPath, ODatabaseType.PLOCAL);
//        this.dbPool = new ODatabasePool(orientDB, orientDBPath, this.properties().getProperty(GraphODB.USER),
//                this.properties().getProperty(GraphODB.PASSWORD));
//        this.dbSession = dbPool.acquire();
    }

}

//    @Override
//    public OEdge connectClusterBefore(OVertex source, OVertex destination) {
//        OEdge e = this.createEdge(source, destination, oClassEdgePrevNext);
//        return e;
//    }

//    /**
//     * Convert txt file of chars UTF-8 into Cluster(ClusterSequence)
//     * @param f
//     * @return
//     */
//    public Cluster txtFileUtf8ToClusterSequence(File f){
//        Cluster cluster = this.createClusterSequence();
//        ClusterDataChar clDataChar;
//        ICluster clNew = null;
//         BufferedReader br;
//        char ch;
//        int in;
//        try {
//            br = new BufferedReader(
//                    new InputStreamReader(
//                            new FileInputStream(f.getAbsolutePath()), StandardCharsets.UTF_8 ), 1024 );
//            while( (in = br.read() ) !=-1 ){
//                ch = (char)in;
//                clDataChar = this.selectClusterDataCharByValue( String.valueOf(ch) );
//                if( clDataChar==null ){
//                    clDataChar = this.createClusterDataChar( String.valueOf(ch) );
//                    this.save(clDataChar);
//                }
//                clNew = this.createClusterLink(clDataChar);
//                cluster.append(clNew);
//            }
//            br.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return cluster;
//    }
