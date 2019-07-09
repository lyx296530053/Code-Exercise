package FileTest;

import java.io.File;

/**
 * Created by lyx on 2019/4/13.
 */
public class FileDelete2 {
    public static void main(String[] args){
        FileDelete2 fileDelete2=new FileDelete2();
        fileDelete2.delete(new File("E:\\Tencent\\TGP"));
    }
    public  void delete(File file){
        File[] files=file.listFiles();
        if(files!=null&&files.length!=0){
            for (File f:files){
                this.delete(f);
            }
        }
        file.delete();
        System.out.println(file.getName()+"文件删除成功");
    }
}
