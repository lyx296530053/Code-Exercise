package cn.lyx.Class;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class MyClassLoader extends ClassLoader {
    private String rootDir;

    public MyClassLoader(String rootDir) {
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

    private byte[] getClassData(String name) {
        String dir = getRealDir(name);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(dir);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[2048];
            int n;
            while ((n = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, n);
            }
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getRealDir(String name) {
        return rootDir + "\\" + name + ".class";
    }
}
