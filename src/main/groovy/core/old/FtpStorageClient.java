package core.old;

//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;
//
//import java.io.IOException;

/**
 * client for manipulation wuth files in ftp-server
 */
public class FtpStorageClient {
//    private FTPClient client;
//    private String hostname;
//    private int port;
//    private String userName;
//    private String userPass;

    /**
     * constructor for init ftp client
     *
     * @param hostname
     * @param port
     * @param userName
     * @param userPass
     */
//    public FtpStorageClient(String hostname, int port, String userName, String userPass) {
//        this.setHostname(hostname);
//        this.setPort(port);
//        this.setUserName(userName);
//        this.setUserPass(userPass);
//    }
//
//    /**
//     * connect with ftp via client
//     *
//     * @return
//     */
//    public boolean connect() {
//        boolean result = true;
//        FTPClient client = new FTPClient();
//        try {
//            client.connect(this.hostname, this.port);
//            client.login(this.userName, this.userPass);
//        } catch (IOException e) {
//            result = false;
//            e.printStackTrace();
//        }
//        this.setClient(client);
//        return result;
//    }
//
//    public FTPFile[] getFiles(){
//        FTPFile[] dirFiles = null;
//        try{
//            dirFiles = this.client.listFiles();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return dirFiles;
//    }
//
//    /**
//     * disconnect from ftp via client
//     *
//     * @return
//     */
//    public boolean disconnect() {
//        boolean result = true;
//        try {
//            this.client.logout();
//            this.client.disconnect();
//            this.setClient(null);
//        } catch (IOException e) {
//            result = false;
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    public String getHostname() {
//        return hostname;
//    }
//
//    public void setHostname(String hostname) {
//        this.hostname = hostname;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserPass() {
//        return userPass;
//    }
//
//    public void setUserPass(String userPass) {
//        this.userPass = userPass;
//    }
//
//    public FTPClient getClient() {
//        return client;
//    }
//
//    public void setClient(FTPClient client) {
//        this.client = client;
//    }

}