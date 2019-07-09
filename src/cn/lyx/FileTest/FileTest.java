package FileTest;

import java.io.File;
import java.io.IOException;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileTest {
    public static void main(String[] args){
//        FileCopy4 fileCopy=new FileCopy4();
//        File file=new File("D:\\music");
//        fileCopy.fileCopy(file,"D:\\File");
        File file=new File("helloword.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
