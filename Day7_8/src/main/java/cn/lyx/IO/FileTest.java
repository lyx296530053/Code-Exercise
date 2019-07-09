package cn.lyx.IO;

import java.io.FileReader;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("Day7_8\\src\\main\\java\\cn\\lyx\\ioc\\Test.java");
        char[] chars=new char[1024];
        int a;
        while( (a=fileReader.read(chars))!=-1){
            String s=new String(chars,0,chars.length);
            System.out.println(s);
        }
    }
}
