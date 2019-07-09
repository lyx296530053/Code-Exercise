package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileDelete {
    public static void main(String [] args){
        FileDelete fileDelete=new FileDelete();
        File file=new File("D:\\QLDownload");
        fileDelete.delete(file);
    }
    public void delete(File file){
       File[] files=file.listFiles();
       if(files!=null&&files.length!=0){
           for (File f:files
                ) {
               this.delete(f);
           }
       }
       file.delete();
       System.out.println(file.getName()+"删除成功");
    }
}
