package FileTest;

import java.io.File;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileShow {
    public static void main(String[] args){
        FileShow fileShow=new FileShow();
        File file=new File("D:\\music");
        fileShow.showFile(file);
    }
    public void showFile(File file){
        File[] file1=file.listFiles();
        if(file1!=null&&file1.length!=0){
            for (File f:file1){
                this.showFile(f);
            }
        }
        System.out.println(file);

    }
}
