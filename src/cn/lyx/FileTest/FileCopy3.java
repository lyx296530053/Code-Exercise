package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lyx on 2019/4/13.
 */
public class FileCopy3 {
    public void fileCopy(File file, String newPath){
        File[] files=file.listFiles();
        File file1=new File(newPath+file.getAbsolutePath().split(":")[1]);
        if(files!=null&&files.length!=0){
            file1.mkdir();
            for (File f:files
                 ) {
                this.fileCopy(f,newPath);
            }
        }else {
            FileInputStream fis=null;
            FileOutputStream fos=null;
            try {
                fis=new FileInputStream(file);
                fos=new FileOutputStream(file1);
                byte[] b=new byte[1024];
                int count=fis.read(b);
                while(count!=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count=fis.read(b);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getName()+"复制完毕");
    }
}
