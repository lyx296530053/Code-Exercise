package cn.lyx.IO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class IOTest {
    @Test
    public void test() {
        fileCopy1(new File("D:\\Notepad++"), new File("D:\\share"));
    }

    public void fileCopy(File file, File newFile) {
        File[] files = file.listFiles();
        File newFilePath = new File(newFile.getAbsolutePath() + file.getAbsolutePath().split(":")[1]);
        if (file.isDirectory()) {
            newFilePath.mkdir();
            for (File file1 : files) {
                fileCopy(file1, newFile);
            }
        } else {
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            FileOutputStream fileOutputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                fileOutputStream = new FileOutputStream(newFilePath);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = bufferedInputStream.read(buffer)) != -1) {
                    bufferedOutputStream.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("阳光.jpg");
            File destFile = new File("阳光.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testStreamToReaderAndWriter() throws Exception {
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        isr.close();
        osw.close();
    }

    static class Person implements Serializable {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void testObjectStream() throws IOException {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            ois = new ObjectInputStream(new FileInputStream("data.dat"));
            oos.writeObject(new Person("lyx", 18));
            oos.flush();
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            oos.close();
            ois.close();
        }
    }

    @Test
    public void NIOServer() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket serverSocket = ssc.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8899);
        serverSocket.bind(inetSocketAddress);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    SocketChannel channel = (SocketChannel) next.channel();
                    System.out.println(getData(channel));
                    channel.close();
                }
                iterator.remove();
            }
        }
    }

    @Test
    public void NIOCilent() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("111".getBytes());
        outputStream.close();
    }

    private static String getData(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            buffer.clear();
            int n = channel.read(buffer);
            if (n == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            stringBuilder.append(dst);
            buffer.clear();
        }
        return stringBuilder.toString();
    }

    public void fileCopy1(File file, File newFile) {
        File[] files = file.listFiles();
        File newFilePath = new File(newFile.getAbsolutePath() + file.getAbsolutePath().split(":")[1]);
        if (file.isDirectory()) {
            newFilePath.mkdir();
            for (File file1 : files) {
                fileCopy1(file1, newFile);
            }
        } else {
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;

            try {
                fileInputStream = new FileInputStream(file);
                FileChannel fisc = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(newFilePath);
                FileChannel fosc = fileOutputStream.getChannel();
               ByteBuffer buffer=ByteBuffer.allocate(2048);
               while (true){
                   int read = fisc.read(buffer);
                   if(read==-1){
                       break;
                   }
                   buffer.flip();
                   fosc.write(buffer);
                   buffer.clear();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
