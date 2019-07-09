package FileTest;

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

public class NIOserver {
    public static void main(String[] args) throws IOException {
        Selector open = Selector.open();
        ServerSocketChannel open1 = ServerSocketChannel.open();
        open1.configureBlocking(false);
        open1.register(open,SelectionKey.OP_ACCEPT);
        ServerSocket socket = open1.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8899);
        socket.bind(inetSocketAddress);
        while (true){
            open.select();
            Set<SelectionKey> selectionKeys = open.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
           while(iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(open,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    SocketChannel  socketChannel= (SocketChannel)next.channel();
                    System.out.println(dataRead(socketChannel));
                    socketChannel.close();
                }
                iterator.remove();
            }
        }
    }
    private static String dataRead(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);
        StringBuilder sb=new StringBuilder();
        while(true){
            int read = socketChannel.read(byteBuffer);
            if(read==-1){
                break;
            }
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            char[] arr=new char[limit];
            for (int i = 0; i < limit; i++) {
                arr[i] =(char) byteBuffer.get(i);
            }
            sb.append(arr);
            byteBuffer.clear();
        }
        return sb.toString();
    }
}
