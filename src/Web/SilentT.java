package Web;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import sun.security.jca.GetInstance;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SilentT {
    public static void main(String[] args){
        try {
            Socket cilent=new Socket("127.0.0.1",8899);
            System.out.println("连接服务器成功，服务器地址为"+cilent.getInetAddress());
            PrintStream out=new PrintStream(cilent.getOutputStream(),true,"utf-8");
            Scanner in=new Scanner(cilent.getInputStream());
            out.println(new Scanner(System.in).nextLine());
            in.useDelimiter("\n");
                 while(true) {
                     if(in.hasNext()) {
                         System.out.println("服务器发送消息为:" + in.next());
                         String str=new Scanner(System.in).nextLine();
                         out.println(str);
                         if(str.equals("byebye")){
                             System.out.println("断开连接");
                             break;
                         }
                     }
                 }
                 in.close();
                 cilent.close();
                 out.close();

        } catch (IOException e) {
            System.out.println("服务器连接异常，错误为"+e);
        }

    }
}
