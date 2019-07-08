package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.register(selector,SelectionKey.OP_ACCEPT);
        ServerSocket socket = ssc.socket();
        socket.bind(new InetSocketAddress("127.0.0.1",8899));
        while(true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    System.out.println("join");
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_WRITE);
                }
                if(next.isWritable()){
                    SocketChannel channel = (SocketChannel) next.channel();
                    System.out.println(read(channel));
                    channel.close();
                }
                iterator.remove();
            }
        }
    }
    public static String read(SocketChannel channel) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);
        StringBuilder datd=new StringBuilder();
        while(true){
            int read = channel.read(byteBuffer);
            if(read==-1){
                break;
            }
            int limit = byteBuffer.limit();
            char[] arr=new char[limit];
            for (int i = 0; i < limit; i++) {
                arr[i]=(char)byteBuffer.get(i);
            }
            datd.append(arr);
            byteBuffer.clear();
        }
        return datd.toString();
    }
}
