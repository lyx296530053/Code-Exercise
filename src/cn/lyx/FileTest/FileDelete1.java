package FileTest;

import java.io.File;

/**
 * Created by lyx on 2019/4/12.
 */
public class FileDelete1 {
    public static void main(String[] args){
        FileDelete1 fileDelete1=new FileDelete1();
        File file=new File("E:\\hyxd");
        fileDelete1.fileDelete(file);
    }
    public void fileDelete(File file){
        File[] files=file.listFiles();
        if(files!=null&&files.length!=0){
            for (File f:files
                 ) {
                this.fileDelete(f);
            }
        }
        file.delete();
        System.out.println(file.getName()+"删除成功");
    }
}
