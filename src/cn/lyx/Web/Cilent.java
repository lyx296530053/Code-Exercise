package Web;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cilent {
    public static void cilent() {
        Socket socket=null;
        OutputStream outputStream=null;
        try {
            InetAddress ine = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ine, 8899);
            outputStream = socket.getOutputStream();
            outputStream.write("hello,我是客户端".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(outputStream!=null){
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void cilentFile(){
        Socket socket=null;
        FileInputStream fis=null;
        OutputStream ops=null;
        BufferedInputStream bis=null;
        InputStream inputStream=null;
        ByteArrayOutputStream bos=null;
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            socket= new Socket(byName, 8899);
            fis=new FileInputStream(new File("D:\\music\\薛之谦 - 我知道你都知道.mp3"));
            bis=new BufferedInputStream(fis);
            ops= socket.getOutputStream();
             byte[] b=new byte[1024];
             int count;
             while((count=bis.read(b))!=-1){
                 ops.write(b,0,count);
                 ops.flush();
             }
             socket.shutdownOutput();
             inputStream= socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(inputStream);
            char[] chars=new char[1024];
            int count1;
             while((count1=isr.read(chars))!=-1){
                String s=new String(chars,0,count1);
                System.out.println(s);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos!=null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis!=null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ops!=null) {
                    ops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args){
        Cilent.cilentFile();
    }
}
