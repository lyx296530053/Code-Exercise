package Web;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerT {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8899);
        try {
            System.out.println("等待客户端连接。。。");
            Socket cilent = server.accept();
            System.out.println("有新的客户端连接，端口号为"+cilent.getPort());
            Scanner In=new Scanner(cilent.getInputStream());
            In.useDelimiter("\n");
            PrintStream outStream=new PrintStream(cilent.getOutputStream(),true,"utf-8");
            while(true) {
                if(In.hasNext()) {
                    System.out.println(cilent.getInetAddress() + "说:" + In.next());
                    outStream.println(new Scanner(System.in).nextLine());
                    if (cilent.isClosed()) {
                        System.out.println("客户端断开连接");
                        break;
                    }
                }
            }
            cilent.close();
            In.close();
            outStream.close();
        }catch (IOException e){
            System.out.println("服务器通信异常错误为"+e);
        }
    }
}
