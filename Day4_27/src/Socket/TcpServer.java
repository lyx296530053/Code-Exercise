package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;
        {
            try {
                ss = new ServerSocket(8899);
                socket = ss.accept();
                is = socket.getInputStream();
               fos=new FileOutputStream(new File("hello1.txt"),true);
                byte[] b = new byte[1024];
                int count;
                while ((count = is.read(b)) != -1) {
                    fos.write(b, 0, count);
                }
                System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");
                OutputStream os = socket.getOutputStream();
                os.write("我已经收到".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    //5.关闭资源
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
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
                if (ss != null) {
                    try {
                        ss.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
