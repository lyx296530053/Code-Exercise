package Web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void server(){
        ServerSocket serverSocket=null;
        InputStream inputStream=null;
        Socket accept=null;
        ByteArrayOutputStream baos=null;
        try {
            serverSocket=new ServerSocket(8899);
            accept= serverSocket.accept();
            inputStream= accept.getInputStream();
            baos=new ByteArrayOutputStream();
            byte[] b=new byte[4];
            int count;
            while((count=inputStream.read(b))!=-1){
                baos.write(b,0,count);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(serverSocket!=null) {
                    serverSocket.close();
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
                if(accept!=null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos!=null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void serverFile(){
        InputStream inputStream=null;
        FileOutputStream fos=null;
        Socket accept=null;
        ServerSocket serverSocket=null;
        OutputStream outputStream=null;
        try {
            serverSocket= new ServerSocket(8899);
            accept= serverSocket.accept();
            inputStream= accept.getInputStream();
            fos=new FileOutputStream(new File("D:\\File\\helo.mp3"));
            byte[] b=new byte[1024];
            int count;
            while((count=inputStream.read(b))!=-1){
                fos.write(b,0,count);
                fos.flush();
            }
            System.out.println("这是一首歌曲");
            outputStream= accept.getOutputStream();
            outputStream.write("我已经收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream!=null) {
                    outputStream.close();
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
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(serverSocket!=null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(accept!=null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args){
        Server.serverFile();
    }
}
