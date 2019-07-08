package FileTest;

import java.io.*;

/**
 * Created by lyx on 2019/4/11.
 */
public class FileCopy {
    public  void fileCopy(File file, String path){
        String old=file.getAbsolutePath();
        String aft=path+old.split(":")[1];
        File file2=new File(aft);
        File[] file1=file.listFiles();
        if(file1!=null){
            file2.mkdir();
            if(file1.length!=0){
                for (File f:file1
                     ) {
                    this.fileCopy(f,path);
                }
            }
        }else{
            FileInputStream fis=null;
            FileOutputStream fos=null;
            try {
                fis=new FileInputStream(file);
                fos=new FileOutputStream(file2,true);
                byte[] b=new byte[1024];
                int count=fis.read(b);
                while(count!=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count=fis.read(b);
                }
                System.out.println(file2.getName()+"文件复制完毕");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }finally {
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
    }

