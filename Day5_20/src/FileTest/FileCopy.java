package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileCopy fileCopy=new FileCopy();
        fileCopy.fileCopy(new File("D:\\music"),new File("D:\\File"));
    }
    public void fileCopy(File file,File newFile){
        File[] files = file.listFiles();
        File newName=new File(newFile.getAbsolutePath()+file.getAbsolutePath().split(":")[1]);
        if(files!=null&&file.length()>0){
            newName.mkdir();
            for (File file1 : files) {
                this.fileCopy(file1,newFile);
            }
        }else{FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newName);
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
    }
}
