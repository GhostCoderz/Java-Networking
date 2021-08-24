import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TDPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serSock = new ServerSocket(9999);
        System.out.println("Waiting for the client...");

        while(true) {
            Socket sock = serSock.accept();
            SocketService socService = new SocketService(sock);
            socService.run();
        }

    }

}
