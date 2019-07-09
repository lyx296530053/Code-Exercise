package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileCopy1 {
    public void fileCopy(File file,String path){

        File[] files=file.listFiles();
        File file1=new File(path+file.getAbsolutePath().split(":")[1]);
        if(files!=null){
            file1.mkdir();
            if(files.length!=0){
                for (File t:files
                     ) {
                    this.fileCopy(t,path);
                }
            }
        }else{
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(file1.getName()+"复制完毕");
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
    }
}
