package core.old;

//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamPanel;
//import com.github.sarxos.webcam.WebcamResolution;
//import com.github.sarxos.webcam.WebcamUtils;
//import com.github.sarxos.webcam.util.ImageUtils;
//import org.apache.commons.cli.*;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.ftpserver.ftplet.FtpException;
//import org.junit.Test;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {
//    String dirIn = "D:\\temp\\in\\";
//    String dirOut = "D:\\temp\\out\\";
//    String imageFile = "star3.png";
//    String edgesFile = "edges.edg";
//    String vertexesFile = "vertexes.edg";
//    String asciiFile = "ascii.txt";
//
//    @Test
//    public void ftpGetFileList() throws FtpException {
//        String hostname = "localhost";
//        int port = 2221;
//        String user = "admin";
//        String pass = "adminpass";
//        FtpStorageClient client = new FtpStorageClient(hostname, port, user, pass);
//
//        client.connect();
//
//        FTPFile[] dirFiles = client.getFiles();
//        for (FTPFile f: dirFiles) { System.out.println(f.getName()); }
//
//        client.disconnect();
//    }

//    @Test
//    public void saveCurrent(){
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();
//        // creates test1.bmp
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_BMP);
//        // creates test1.gif
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_GIF);
//        // creates test1.jpg
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_JPG);
//        // creates test1.png
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_PNG);
//        // creates test1.wbmp
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_WBMP);
//    }

//    @Test
//    public void windowWithCamData(){
//        Webcam webcam = Webcam.getDefault();
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//        WebcamPanel panel = new WebcamPanel(webcam);
//        panel.setFPSDisplayed(true);
//        panel.setDisplayDebugInfo(true);
//        panel.setImageSizeDisplayed(true);
//        panel.setMirrored(true);
//
//        JFrame window = new JFrame("Test webcam panel");
//        window.add(panel);
//        window.setResizable(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.pack();
//        window.setVisible(true);
//    public static void main(String[] args) throws InterruptedException {
//        new WebCameraTest().windowWithCamData();
//    }
//    }

    public static void main ( String [] arguments ) {
//        // parse input parameters
//        Options options = new Options();
//        options.addRequiredOption("i", "in", true, "source in");
//        options.addRequiredOption("o", "out", true, "source out");
//        options.addRequiredOption("t", "transformPoints", true, "algorithm");
//        options.addOption("p1", true, "algorithm parameter1");
//        options.addOption("p2", true, "algorithm parameter2");
//        options.addOption("p3", true, "algorithm parameter3");
//        options.addOption("p4", true, "algorithm parameter4");
//        options.addOption("p5", true, "algorithm parameter5");
//        CommandLine commandLine;
//        CommandLineParser parser = new DefaultParser();
//        try {
//            commandLine = parser.parse(options, arguments);
//        } catch (ParseException e) {
//            throw new RuntimeException("Can't parse command line correctly", e);
//        }
//        String in = commandLine.getOptionValue("in");
//        String out = commandLine.getOptionValue("out");
//        String transform = commandLine.getOptionValue("transformPoints");
//        String p1 = commandLine.getOptionValue("p1");
//        String p2 = commandLine.getOptionValue("p2");
//        String p3 = commandLine.getOptionValue("p3");
//        String p4 = commandLine.getOptionValue("p4");
//        String p5 = commandLine.getOptionValue("p5");
    }

}