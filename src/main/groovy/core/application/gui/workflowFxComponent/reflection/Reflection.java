package core.application.gui.workflowFxComponent.reflection;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Reflection {

    public static Collection<Class> getClasses(Package pkg) throws Exception {
        String pack = pkg.getName();
        final StandardJavaFileManager fileManager = ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null);
        return StreamSupport.stream(fileManager.list(StandardLocation.CLASS_PATH, pack, Collections.singleton(JavaFileObject.Kind.CLASS), false).spliterator(), false)
                .map(javaFileObject -> {
                    try {
                        final String[] split = javaFileObject.getName()
                                .replace(".class", "")
                                .replace(")", "")
                                .split(Pattern.quote(File.separator));
                        final String fullClassName = pack + "." + split[split.length - 1];
                        return Class.forName(fullClassName);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                })
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static Collection<Method> getClassStaticMethods(Class<?> clazz) {
        List<Method> classStaticMethods = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if (Modifier.isStatic(method.getModifiers())) {
                classStaticMethods.add(method);
            }
        }
        return classStaticMethods;
    }

}
