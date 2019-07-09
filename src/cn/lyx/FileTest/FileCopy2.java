package FileTest;

import java.io.*;

/**
 * Created by lyx on 2019/4/12.
 */
public class FileCopy2 {
    public void fileCopy(File file,String newPath){
        File[] files=file.listFiles();
        File file1=new File(newPath+file.getAbsolutePath().split(":")[1]);
        if(files!=null){
            file1.mkdir();
            if(files.length!=0) {
                for (File f : files
                        ) {
                    this.fileCopy(f, newPath);
                }
            }
        }else {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(file1);
                byte[] b = new byte[1024];
                int count = fis.read(b);
                while (count != -1) {
                    fos.write(b, 0, count);
                    fos.flush();
                    count = fis.read(b);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(file.getName()+"复制完毕");
    }
}
