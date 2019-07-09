package cn.lyx.ClassLoaderTest;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.FileInputStream;
import java.io.IOException;


class MyClassLoader extends ClassLoader {
    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    public Class<?> getClass(String className) throws IOException {
        byte[] b = getClassData(className);
        if (b == null) {
            throw new IOException("文件不存在");
        } else {
            return defineClass(className, b, 0, b.length);
        }
    }

    private byte[] getClassData(String name) {
        String path = getRealPath(name);
        FileInputStream inputStream = null;
        ByteOutputStream b = null;
        try {
            inputStream = new FileInputStream(path);
            b = new ByteOutputStream();
            byte[] bytes = new byte[1024];
            int p;
            while ((p = inputStream.read(bytes)) != -1) {
                b.write(bytes, 0, p);
                b.flush();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }

    private String getRealPath(String name) {
        return path + "\\" + name + ".class";
    }
}

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        Class<?> student = new MyClassLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\Day7_8\\target\\classes\\cn\\lyx\\IO").getClass("FileTest");

        System.out.println(student);
    }
}
