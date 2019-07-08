package ChatRoom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {

    private static Map<String, Socket> CILENT_MAP
            = new ConcurrentHashMap<>();

    private static class HandleCilent implements Runnable {
        private Socket cilent;

        public HandleCilent(Socket cilent) {
            this.cilent = cilent;
        }

        @Override
        public void run() {
            try {
                Scanner in = new Scanner(cilent.getInputStream());
                String str;
                while (true) {
                    if (in.hasNext()) {
                        str = in.nextLine();
                        if (str.startsWith("R")) {
                            String[] username = str.split(":");
                            if (username[0].equals("R") && username.length == 2) {
                                register(username[1], this.cilent);
                            }
                            continue;
                        }
                        if (str.startsWith("G")) {
                            String[] chat = str.split(":");
                            if (chat[0].equals("G") && chat.length == 2) {
                                groupChat(chat[1]);
                            }
                            continue;
                        }
                        if (str.startsWith("P")) {
                            String[] chat = str.split(":");
                            if (chat.length == 3 && chat[0].equals("P")) {
                                privateChat(chat[1], chat[2]);
                            }
                            continue;
                        }
                        if (str.equals("byebye")) {
                            quit(cilent);
                            continue;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void quit(Socket cilent) {
            String userName = null;
            for (String s : CILENT_MAP.keySet()) {
                if (CILENT_MAP.get(s).equals(cilent)) {
                    userName = s;
                }
            }
            System.out.println("用户" + userName + "下线了。。。");
            CILENT_MAP.remove(userName);
            show();
        }

        private void privateChat(String s, String s1) {
            Socket socket = CILENT_MAP.get(s);
            try {
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                Set<Map.Entry<String, Socket>> entries = CILENT_MAP.entrySet();
                for (Map.Entry<String, Socket> entry : entries) {
                    if (entry.getValue() == this.cilent) {
                        printStream.println("私信消息：" + entry.getKey() + "说：" + s1);
                        printStream.flush();
                    }
                }
            } catch (IOException e) {
                System.err.println("私聊异常，错误为" + e);
            }
        }

        private void groupChat(String chat) {

            Set<Map.Entry<String, Socket>> entries = CILENT_MAP.entrySet();
            for (Map.Entry<String, Socket> entry : entries) {
                OutputStream outputStream = null;
                try {
                    if (entry.getValue() == this.cilent) {
                        continue;
                    }
                    outputStream = entry.getValue().getOutputStream();
                    PrintStream printStream = new PrintStream(outputStream);
                    for (Map.Entry<String, Socket> entrys : entries) {
                        if (entrys.getValue() == this.cilent) {
                            printStream.println("群聊消息：" + entrys.getKey() + "说：" + chat);
                            printStream.flush();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        private void register(String username, Socket cilent) {
            Set<Map.Entry<String, Socket>> entries = CILENT_MAP.entrySet();
            for (Map.Entry<String, Socket> entry : entries) {
                if (entry.getValue() == cilent) {
                    return;
                }
            }
            CILENT_MAP.put(username, cilent);
            try {
                PrintStream printStream = new PrintStream(cilent.getOutputStream());
                printStream.println("恭喜注册成功!!!");
                show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void show() {
            System.out.println("当前在线的客户端有" + CILENT_MAP.size() + " 名称列表如下：");
            for (String key : CILENT_MAP.keySet()) {
                System.out.println(key);
            }
        }
    }

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10, new ThreadFactory() {
        private final AtomicInteger id = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Thread-Client-Handler-" + id.getAndIncrement());
            return t;
        }
    });

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务器端启动  " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            while (true) {
                System.out.println("等待客户端连接。。。");
                Socket cilent = serverSocket.accept();
                System.out.println("有客户端连接端口号为：" + cilent.getPort());
                EXECUTOR_SERVICE.execute(new HandleCilent(cilent));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
