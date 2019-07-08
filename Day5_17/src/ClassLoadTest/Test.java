package ClassLoadTest;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String classNameToPath(String className) {
        return rootDir+"\\"
                + className.replace('.',File.separatorChar)+ ".class";
    }
}
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        Class cls=new FileSystemClassLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").findClass("Student");
//        Constructor constructor = cls.getConstructor(String.class);
//        constructor.setAccessible(true);
//        Object o=constructor.newInstance("hello");
//        Field name = o.getClass().getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(o,"abc");
//        System.out.println(name.get(o));
//        Method student = cls.getDeclaredMethod("Student", String.class);
//        student.setAccessible(true);
//        student.invoke(o,"lyx");
        System.out.println( new FileSystemClassLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").getParent());
        System.out.println( new FileSystemClassLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").getParent().getParent());
        System.out.println( new FileSystemClassLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").getParent().getParent().getParent());
    }
}
