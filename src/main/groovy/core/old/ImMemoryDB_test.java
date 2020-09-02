package core.old;

import com.orientechnologies.orient.core.Orient;
import com.orientechnologies.orient.core.db.*;
import org.junit.Test;

public class ImMemoryDB_test {

    @Test
    public void dbInMemory() {
        String orientDBPath = "memory:visdb";
        OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();

        OrientDB orientDB = new OrientDB(orientDBPath, dbConfig);
        orientDB.createIfNotExists(orientDBPath, ODatabaseType.MEMORY);
        ODatabasePool pool = new ODatabasePool(orientDB, orientDBPath, "admin",
                "admin");
        ODatabaseSession session = pool.acquire();

        // later
        session.close();
        pool.close();
        orientDB.close();
    }

    @Test
    public void dbEmbedded() {
        String orientDBName = "embeddedDB", username = "john", password = "12345678";
        OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();
        ODatabasePoolInternal documentPoolInternal;
        OrientDBEmbedded orientDBEmbedded = new OrientDBEmbedded("", dbConfig, Orient.instance());
        orientDBEmbedded.create(orientDBName, username, password, ODatabaseType.MEMORY, dbConfig);
        documentPoolInternal = orientDBEmbedded.openPool(orientDBName, username, password);
        ODatabaseSession session = documentPoolInternal.acquire();
        // later
        session.close();
        documentPoolInternal.close();
        session.close();
        orientDBEmbedded.close();
    }

}
