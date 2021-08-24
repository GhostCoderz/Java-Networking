import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread implements Runnable{

    Socket sock;

    public SocketThread(Socket sock)
    {
        this.sock=sock;
    }

    @Override
    public void run() {
        try {
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();

            System.out.println("Reading the input....");
            byte[] response = new byte[1024];
            in.read(response);
            String strResponse=new String(response).trim();
            System.out.println("Input from the client is : " + strResponse);

            System.out.println("Sending message to the client....");
            out.write("Got your message".getBytes());
            sock.close();
        }catch (Exception e) {}
    }

}
