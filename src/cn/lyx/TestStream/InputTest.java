package TestStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lyx on 2019/4/11.
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\File");
        File filel = new File(file.getPath(), "123.jpg");
        boolean newFile = filel.createNewFile();
        FileInputStream fls=new FileInputStream(filel);
        int ii=fls.available();
        System.out.println(ii);
        byte[] b=new byte[3];
        int i=fls.read(b);
        while (i!=-1){
            String value=new String(b,0,i);
            System.out.print(value);
            i=fls.read(b);
        }
        FileInputStream fis=new FileInputStream(filel);
        int a=fis.read();//读取一个字节
        while (a!=-1) {
            System.out.println((char)a);
            a=fis.read();
        }
    }
}
