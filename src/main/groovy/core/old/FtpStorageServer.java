package core.old;

//import org.apache.ftpserver.FtpServer;
//import org.apache.ftpserver.FtpServerFactory;
//import org.apache.ftpserver.ftplet.Authority;
//import org.apache.ftpserver.ftplet.FtpException;
//import org.apache.ftpserver.ftplet.UserManager;
//import org.apache.ftpserver.listener.ListenerFactory;
//import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
//import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
//import org.apache.ftpserver.usermanager.impl.BaseUser;
//import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FtpStorageServer {
//    private FtpServer server;
//    private String localFtpDir;
//    private int localFtpPort;
//    private UserManager userManager;
//    private BaseUser readUser;
//    private BaseUser adminUser;

//    /**
//     * create UserManager
//     * @param pathToFileUsers to file where stored all users encryptedData
//     */
//    private static UserManager createUserManager(String pathToFileUsers) {
//        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//        userManagerFactory.setFile(new File(pathToFileUsers));
//        userManagerFactory.setPasswordEncryptor(new SaltedPasswordEncryptor());
//        return userManagerFactory.createUserManager();
//    }
//
//    /**
//     * create UserManager without file
//     * @return
//     */
//    private static UserManager createUserManager() {
//        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//        return userManagerFactory.createUserManager();
//    }
//
//    /**
//     * create BaseUser
//     * @param userManager
//     * @param name
//     * @param password
//     * @param homeDir
//     * @param authorities
//     * @return
//     */
//    private static BaseUser createUser(UserManager userManager, String name, String password, String homeDir, List<Authority> authorities) {
//        BaseUser user = new BaseUser();
//        user.setName(name);
//        user.setPassword(password);
//        user.setHomeDirectory(homeDir);
//        user.setAuthorities(authorities);
//        user.setMaxIdleTime(360);
//        return user;
//    }
//
//    /**
//     * add user via UserManager
//     * @param userManager
//     * @param user
//     * @return
//     */
//    private boolean addUser(UserManager userManager, BaseUser user) {
//        boolean result = true;
//        try {
//            userManager.save(user);
//        } catch (FtpException e) {
//            result = false;
//            e.printStackTrace();
//        }
//        return result;
//
//    }
//
//    /**
//     * start ftpServer
//     */
//    private boolean createFtpServer(String ftpDir, int ftpPort,
//                                     String adminName, String adminPass,
//                                     String userName, String userPass){
//        boolean result = true;
//        this.localFtpDir = ftpDir;
//        this.localFtpPort = ftpPort;
//        this.userManager = FtpStorageServer.createUserManager();
//        this.adminUser = FtpStorageServer.createUser( this.userManager, adminName, adminPass,
//                ftpDir, Collections.singletonList(new WritePermission()) );
//        this.readUser = FtpStorageServer.createUser( this.userManager, userName, userPass,
//                ftpDir, new ArrayList<>() );
//        try {
//            this.userManager.save(this.adminUser);
//            this.userManager.save(this.readUser);
//        } catch (FtpException e) {
//            result = false;
//            e.printStackTrace();
//        }
//        // run ftp server
//        ListenerFactory listenerFactory = new ListenerFactory();
//        listenerFactory.setPort(ftpPort);
//        FtpServerFactory factory = new FtpServerFactory();
//        factory.setUserManager(userManager);
//        factory.addListener("default", listenerFactory.createListener());
//        this.server = factory.createServer();
//        return result;
//    }
//
//    // ================================================= PUBLIC ========================================================
//
//    /**
//     * empty constructor initialization
//     */
//    public FtpStorageServer(){
//
//    }
//
//    /**
//     * constructor for init FtpStorageServer
//     * @param ftpDir
//     * @param ftpPort
//     * @param adminName
//     * @param adminPass
//     * @param userName
//     * @param userPass
//     */
//    public FtpStorageServer(String ftpDir, int ftpPort,
//                            String adminName, String adminPass,
//                            String userName, String userPass){
//        this.createFtpServer(ftpDir, ftpPort, adminName, adminPass, userName, userPass);
//    }
//
//    /**
//     * start FTP server storage
//     * @return
//     */
//    public boolean start(){
//        boolean result = true;
//        try {
//            this.server.start();
//        } catch (FtpException e) {
//            result = false;
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * stop FTP server storage
//     * @return
//     */
//    public boolean stop(){
//        boolean result = true;
//        this.server.stop();
//        return result;
//    }

}
