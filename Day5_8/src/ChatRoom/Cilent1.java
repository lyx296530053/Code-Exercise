package ChatRoom;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ReadServer1 extends Thread {
    private Socket read;

    public ReadServer1(Socket read) {
        this.read = read;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(this.read.getInputStream());
            while (true) {
                if (scanner.hasNext()) {
                    System.out.println("从服务器发来消息：" + scanner.next());
                }
                if (read.isClosed()) {
                    System.out.println("客户端已关闭");
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("客户端读线程异常，错误为 " + e);
        }
    }
}

class WriteServer1 extends Thread {
    private Socket write;

    public WriteServer1(Socket write) {
        this.write = write;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            PrintStream printStream = new PrintStream(this.write.getOutputStream());
            while (true) {
                System.out.print("请输入要发送的信息：");
                String str;
                if (scanner.hasNext()) {
                    str = scanner.nextLine();
                    printStream.println(str);
                    printStream.flush();
                    if (str.equals("byebye")) {
                        System.out.println("关闭客户端");
                        scanner.close();
                        printStream.close();
                        this.write.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("客户端写线程异常，错误为 " + e);
        }
    }
}
public class Cilent1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            Thread read = new ReadServer(socket);
            read.setName("Thread-Client-Read");
            Thread write = new WriteServer2(socket);
            write.setName("Thread-Client-Read");
            read.start();
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
