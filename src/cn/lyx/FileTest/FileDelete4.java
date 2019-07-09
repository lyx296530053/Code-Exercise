package FileTest;

import java.io.File;

/**
 * Created by lyx on 2019/4/15.
 */
public class FileDelete4 {
    public static void main(String[] args) {
        FileDelete4 fileDelete4=new FileDelete4();
        fileDelete4.fileDelete(new File("D:\\File"));
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
    }
}
