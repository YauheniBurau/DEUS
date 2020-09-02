package core.old;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public final class ClassFinder {

    private final static char DOT = '.';
    private final static char SLASH = '/';
    private final static String CLASS_SUFFIX = ".class";
    private final static String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the given '%s' package exists?";

    public final static List<Class<?>> find(final String scannedPackage) {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String scannedPath = scannedPackage.replace(DOT, SLASH);
        final Enumeration<URL> resources;
        try {
            resources = classLoader.getResources(scannedPath);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage), e);
        }
        final List<Class<?>> classes = new LinkedList<Class<?>>();
        while (resources.hasMoreElements()) {
            final File file = new File(resources.nextElement().getFile());
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private final static List<Class<?>> find(final File file, final String scannedPackage) {
        final List<Class<?>> classes = new LinkedList<Class<?>>();
        if (file.isDirectory()) {
            for (File nestedFile : file.listFiles()) {
                classes.addAll(find(nestedFile, scannedPackage));
            }
            //File names with the $1, $2 holds the anonymous inner classes, we are not interested on them.
        } else if (file.getName().endsWith(CLASS_SUFFIX) && !file.getName().contains("$")) {

            final int beginIndex = 0;
            final int endIndex = file.getName().length() - CLASS_SUFFIX.length();
            final String className = file.getName().substring(beginIndex, endIndex);
            try {
                final String resource = scannedPackage + DOT + className;
                classes.add(Class.forName(resource));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }

//    /**
//     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
//     *
//     * @param packageName The base package
//     * @return The classes
//     * @throws ClassNotFoundException
//     * @throws IOException
//     */
//    public static Class[] getClasses(String packageName)
//            throws ClassNotFoundException, IOException {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        assert classLoader != null;
//        String path = packageName.replace('.', '/');
//        Enumeration<URL> resources = classLoader.getResources(path);
//        List<File> dirs = new ArrayList<File>();
//        while (resources.hasMoreElements()) {
//            URL resource = resources.nextElement();
//            dirs.add(new File(resource.getFile()));
//        }
//        ArrayList<Class> classes = new ArrayList<Class>();
//        for (File directory : dirs) {
//            classes.addAll(findClasses(directory, packageName));
//        }
//        return classes.toArray(new Class[classes.size()]);
//    }

//    /**
//     * Recursive method used to find all classes in a given directory and subdirs.
//     *
//     * @param directory   The base directory
//     * @param packageName The package name for classes found inside the base directory
//     * @return The classes
//     * @throws ClassNotFoundException
//     */
//    public static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
//        List<Class> classes = new ArrayList<Class>();
//        if (!directory.exists()) {
//            return classes;
//        }
//        File[] files = directory.listFiles();
//        for (File file : files) {
//            if (file.isDirectory()) {
//                assert !file.getName().contains(".");
//                classes.addAll(findClasses(file, packageName + "." + file.getName()));
//            } else if (file.getName().endsWith(".class")) {
//                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
//            }
//        }
//        return classes;
//    }
//
//    public static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{
//
//        String dottedPackage = pack.replaceAll("[/]", ".");
//        List<Class> classes = new ArrayList<Class>();
//        URL upackage = cl.getResource(pack);
//
//        DataInputStream dis = new DataInputStream((InputStream) upackage.getContent());
//        String line = null;
//        while ((line = dis.readLine()) != null) {
//            if(line.endsWith(".class")) {
//                classes.add(Class.forName(dottedPackage+"."+line.substring(0,line.lastIndexOf('.'))));
//            }
//        }
//        return classes;
//    }
//

//    public static void does(){
//        //        // SET INPUTS CONNECTS VALUES
//        VertexConnect[] connects = wfv1.selectVertexConnects(VertexConnectTypeEnum.IN);
//        connects[0].setValue("hello");
//        connects[1].setValue(24);
//        connects[2].setValue(25.0);
//
//        Object[] args = new Object[3];
//        args[0] = connects[0].getValue();
//        args[1] = connects[1].getValue();
//        args[2] = connects[2].getValue();
//        // EXECUTE VERTEX
//        // SET OUTPUT CONNECT VALUE FROM EXECUTED METHOD
//        VertexConnect outConnect = wfv1.selectVertexConnect(0, VertexConnectTypeEnum.OUT);
//
//        try {
//            outConnect.setValue( wfv1.getMethod().invoke(null, args) );
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        // S.OUT OUTPUT CONNECT VALUE
//        System.out.println( outConnect.getValue() );
//        System.out.println();
//    }

}