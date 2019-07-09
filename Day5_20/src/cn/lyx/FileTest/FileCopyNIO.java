package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopyNIO {
    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();
        fileCopy.fileCopy(new File("D:\\music"), new File("D:\\File"));
    }

    public void fileCopy(File file, File newFile) throws IOException {
        File[] files = file.listFiles();
        File newName = new File(newFile.getAbsolutePath() + file.getAbsolutePath().split(":")[1]);
        if (files != null && file.length() > 0) {
            newName.mkdir();
            for (File file1 : files) {
                this.fileCopy(file1, newFile);
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;
                fis = new FileInputStream(file);
                FileChannel channel = fis.getChannel();
                fos = new FileOutputStream(newName);
                FileChannel channel1 = fos.getChannel();
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                while(true){
                    int read = channel.read(buffer);
                    if(read==-1){
                        break;
                    }
                    buffer.flip();
                    channel1.write(buffer);
                    buffer.clear();
                }
            }
        }
    }