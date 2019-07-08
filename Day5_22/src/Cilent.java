import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cilent {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.close();
    }
}
