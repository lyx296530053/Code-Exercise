package Test_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomIO {
    public static void main(String[] args) {
        RandomAccessFile f1=null;
        RandomAccessFile f2=null;
        try {
            f1=new RandomAccessFile(new File("test.dat"),"r");
            f2=new RandomAccessFile("test1.dat","rw");
            byte[] b=new byte[1024];
            int count;
            while((count=f1.read(b))!=-1){
                f2.write(b,0,count);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if(f1!=null){
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(f2!=null){
                try {
                    f2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        RandomAccessFile raf=null;
        try {
            raf=new RandomAccessFile("hello.txt","rw");
            raf.seek(3);
            StringBuilder sb=new StringBuilder((int)new File("hello.txt").length());
            byte[] b=new byte[1024];
            int count;
            while((count=raf.read(b))!=-1){
                sb.append(new String(b,0,count));
            }
            raf.seek(3);
            raf.write("nihao".getBytes());
            raf.write(sb.toString().getBytes());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
