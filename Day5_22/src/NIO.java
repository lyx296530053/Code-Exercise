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

public class NIO {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket socket = server.socket();
        socket.bind(new InetSocketAddress("127.0.0.1",8899));
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel sock = channel.accept();
                    sock.configureBlocking(false);
                    sock.register(selector, SelectionKey.OP_WRITE);
                }
                if (next.isWritable()) {
                    SocketChannel channel = (SocketChannel) next.channel();
                    System.out.println(read(channel));
                    channel.close();
                }
            }
        }
    }

    private static String read(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = channel.read(buffer);
            if (read == -1) {
                break;
            }
            char[] arr=new char[buffer.limit()];
            for (int i = 0; i < buffer.limit(); i++) {
                arr[i]= (char) buffer.get(i);
            }
            stringBuffer.append(arr);
            buffer.clear();
        }

        return stringBuffer.toString();
    }
}
