package Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
            socket = new DatagramSocket(8090);
            byte[] b=new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(b,0,b.length);
            socket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
