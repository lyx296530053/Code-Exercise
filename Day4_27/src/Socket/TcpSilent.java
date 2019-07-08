package Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class TcpSilent {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InetAddress inet;
        FileInputStream fis=null;
        {
            try {
                inet = InetAddress.getByName("127.0.0.1");
                socket = new Socket(inet, 8899);
                os = socket.getOutputStream();
               fis=new FileInputStream(new File("hello.txt"));
               byte[] b=new byte[1024];
               int count;
               while((count=fis.read(b))!=-1){
                   os.write(b,0,count);
               }
               socket.shutdownOutput();
                InputStream is = socket.getInputStream();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                byte[] b1=new byte[1024];
                int count1;
                while((count=is.read(b))!=-1){
                    baos.write(b,0,count);
                }
                System.out.println(baos.toString());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
