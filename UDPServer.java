import java.io.IOException;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) throws IOException {

        DatagramSocket dgSocket = new DatagramSocket(8989);

        byte [] response=new byte[1000];

        DatagramPacket dp=new DatagramPacket(response,1000);

        dgSocket.receive(dp);

        String msg=new String(dp.getData()).trim();

        System.out.println("packet received from the server : " +msg);
        System.out.println("Server address :" + dp.getSocketAddress());
        System.out.println("Server port : " + dp.getPort());

    }

}
