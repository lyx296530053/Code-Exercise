package TestStream;

import java.io.*;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileCopy {
    //    public void copy(File f,String path) throws IOException {
//        File file1 = new File(path+"//"+f.getName());
//        FileInputStream fis = new FileInputStream(f);
//        byte[] b = new byte[1024];
//        int count = fis.read(b);
//        FileOutputStream fos = new FileOutputStream(file1);
//        while (count != -1) {
//
//            fos.write(b,0,count);
//            fos.flush();
//            count=fis.read(b);
//        }
//    }
    public void superCopyfile(File file, String path) throws IOException {
        File[] files = file.listFiles();
        File newFile = new File(path + file.getAbsolutePath().split(":")[1] + file.getName());
        if (files != null) {
            newFile.mkdir();
            if (files.length != 0) {
                for (File f : files) {
                    this.superCopyfile(f, path);
                }
            } else {
                FileInputStream fis = null;
                FileOutputStream fos = null;
                fis = new FileInputStream(newFile);
                fos = new FileOutputStream(newFile);
                byte[] b = new byte[1024];
                int count = fis.read(b);
                while (count != -1) {
                    fos.write(b, 0, count);
                    fos.flush();
                    count = fis.read(b);
                }
            }

        }
    }
        public static void main (String[] args) throws IOException {
//        FileCopy fc=new FileCopy();
//        fc.copy(new File("C:\\Users\\lyx\\Desktop\\111.txt"),"D:\\File");
            FileCopy fileCopy = new FileCopy();
            fileCopy.superCopyfile(new File("C:\\Users\\lyx\\Music\\bird.wav"), "D:\\File");
        }
    }

