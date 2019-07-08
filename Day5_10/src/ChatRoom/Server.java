package ChatRoom;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    public static Map<String, Socket> map = new ConcurrentHashMap<>();

    private static class Handler implements Runnable {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(socket.getInputStream());
                String str;
                while (true) {
                    if (scanner.hasNext()) {
                        str = scanner.nextLine();
                        if (str.startsWith("R")) {
                            String[] split = str.split(":");
                            if (split[0].equals("R") && split.length == 2) {
                                regist(split[1]);
                            }
                            continue;
                        }
                        if (str.startsWith("G")) {
                            String[] split = str.split(":");
                            if (split[0].equals("G") && split.length == 2) {
                                groupChat(split[1]);
                            }
                            continue;
                        }
                        if (str.startsWith("P")) {
                            String[] split = str.split(":");
                            if (split[0].equals("P") && split.length == 3) {
                                privateChat(split[1], split[2]);
                            }
                            continue;
                        }
                        if (str.startsWith("byebye")) {
                            if ("byebye".equals(str)) {
                                quit(socket);
                                continue;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void quit(Socket socket) {
            String userName = null;
            for (String s : map.keySet()) {
                if (map.get(s).equals(socket)) {
                    userName = s;
                }
            }
            System.out.println("用户" + userName + "下线了。。。");
            map.remove(userName);
            show();
        }

        private void privateChat(String s, String s1) {
            Socket socket1 = map.get(s);
            try {
                PrintStream printStream=new PrintStream(socket1.getOutputStream());
                printStream.println("私信消息：" + "说：" + s1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void groupChat(String s) {
            Set<Map.Entry<String, Socket>> entries = map.entrySet();
            Iterator iterator=entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry next =(Map.Entry) iterator.next();
                if(next.getValue()==this.socket)continue;
                try {
                    PrintStream printStream=new PrintStream(((Socket)next.getValue()).getOutputStream());
                    for (Map.Entry<String, Socket> entrys : entries) {
                        if (entrys.getValue() == this.socket) {
                            printStream.println("群聊消息：" + entrys.getKey() + "说：" + s);
                            printStream.flush();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void regist(String s) {
            Set<Map.Entry<String, Socket>> entries = map.entrySet();
            for (Map.Entry<String, Socket> entry : entries) {
                if (entry.getValue() == this.socket) return;
            }
            map.put(s, this.socket);
            try {
                PrintStream printStream = new PrintStream(this.socket.getOutputStream());
                printStream.println("恭喜注册成功！！！");
                show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void show() {
            System.out.println("当前在线的客户端有" + map.size() + " 名称列表如下：");
            for (String key : map.keySet()) {
                System.out.println(key);
            }
        }
    }

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10, new ThreadFactory() {
        private final AtomicInteger atomicInteger = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Thread-Client-Handler-" + atomicInteger.getAndIncrement());
            return t;
        }
    });

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务器启动" + serverSocket.getInetAddress() + serverSocket.getLocalPort());
            while (true) {
                System.out.println("等待客户端连接。。。");
                Socket cilent = serverSocket.accept();
                System.out.println("有客户端连接端口号为：" + cilent.getPort());
                EXECUTOR_SERVICE.execute(new Handler(cilent));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
