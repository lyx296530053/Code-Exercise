package After;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyLoader extends ClassLoader {
    String root;

    public MyLoader(String root) {
        this.root = root;
    }

    public Class<?> getClass(String className) throws IOException {
        byte[] b = getData(className);
        if (b == null) {
            throw new IOException("文件不存在");
        } else {
            return defineClass(className, b, 0, b.length);
        }
    }

    private byte[] getData(String classPath) throws IOException {
        String path = getPath(classPath);
        InputStream is = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int a = 0;
        while ((a = is.read(b)) != -1) {
            baos.write(b, 0, a);
            baos.flush();
        }
        return baos.toByteArray();
    }

    private String getPath(String classPath) {
        return root + "\\" + classPath + ".class";
    }
}

public class MyclassLoader {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> student = new MyLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").getClass("Student");
        Constructor<?> constructor = student.getConstructor(String.class);
        constructor.setAccessible(true);
        constructor.newInstance("hello");

    }
}
