package Web;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ReadServerThread implements Runnable{
    private Socket cilent;

    public ReadServerThread(Socket cilent) {
        this.cilent = cilent;
    }
    @Override
    public void run() {
        try {
            Scanner in=new Scanner(cilent.getInputStream());
            in.useDelimiter("\n");
            while(true){
                if(in.hasNext()){
                    System.out.println("从服务器发来消息："+in.next());
                }
                if(cilent.isClosed()){
                    System.out.println("客户端已经关闭");
                    break;
                }
            }
            in.close();
        } catch (IOException e) {
          System.out.println("服务器读程序异常:"+e);
        }
    }
}
class WriteServerThreaad implements Runnable{
    private Socket cilent;

    public WriteServerThreaad(Socket cilent) {
        this.cilent = cilent;
    }
    @Override
    public void run() {
        try {
            Scanner in =new Scanner(System.in);
            in.useDelimiter("\n");
            PrintStream out = new PrintStream(cilent.getOutputStream());
            while(true){
                System.out.println("请输入要发送的信息：");
                if(in.hasNext()){
                    String str=in.nextLine().trim();
                    out.println(str);
                    if(str.equals("byebye")){
                        System.out.println("关闭客户端");
                        cilent.close();
                        out.close();
                        in.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("客户端写程序异常"+e);
        }
    }
}
public class Cilents {
    public static void main(String[] args){
        try {
            Socket cilent=new Socket("127.0.0.1",6666);
            Thread write=new Thread(new WriteServerThreaad(cilent));
            Thread read=new Thread(new ReadServerThread(cilent));
            write.start();
            read.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
