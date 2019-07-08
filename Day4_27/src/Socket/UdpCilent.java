package Socket;

import java.net.*;

public class UdpCilent {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
             socket = new DatagramSocket();
            String str="我是UDP发送的导弹，你怎么看";
            byte[] bytes=str.getBytes();
            InetAddress lh= InetAddress.getLocalHost();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,lh,8090);
            socket.send(datagramPacket);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){;
                socket.close();
            }
        }
    }
}
