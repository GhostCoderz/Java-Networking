import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {

        DatagramSocket dgSocket = new DatagramSocket();
        String msg = "Data sent from the server to the client";
        byte[] response = msg.getBytes();

        DatagramPacket dpack = new DatagramPacket(response, response.length,InetAddress.getLocalHost(),8989);
        System.out.println("Sending the data packet to the user");
        dgSocket.send(dpack);
        dgSocket.close();

    }

}
