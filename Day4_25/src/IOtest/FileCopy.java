package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();
        fileCopy.copy(new File("D:\\music"), "D:\\File");
    }

    public void copy(File f, String newPath) {
        File[] files = f.listFiles();
        File file = new File(newPath + f.getAbsolutePath().split(":")[1]);
        if (!f.isFile() && files.length != 0) {
            file.mkdirs();
            for (File ff : files
                    ) {
                this.copy(ff, newPath);
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(f);
                fos = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int count;
                while ((count = fis.read(b)) != -1) {
                    fos.write(b, 0, count);
                    fos.flush();
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
