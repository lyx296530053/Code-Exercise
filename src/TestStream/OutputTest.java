package TestStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lyx on 2019/4/11.
 */
public class OutputTest {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\File\\hello.txt");
        FileOutputStream fos=new FileOutputStream(file,true);
        String str=new String("qwer1+2");
        byte[] a=str.getBytes();
        fos.write(a);
        fos.flush();
    }
}
