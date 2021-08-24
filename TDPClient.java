import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TDPClient {

    public static void main(String[] args) throws IOException {

        System.out.println("Connecting with the server");
        Socket sock =new Socket("127.0.0.1",9999);

        System.out.println("Connected to the server");

        InputStream in=sock.getInputStream();
        OutputStream out=sock.getOutputStream();

        Scanner sc=new Scanner(System.in);
        String inputStr=sc.nextLine();
        out.write(inputStr.getBytes());
        out.write("This is the message from the client".getBytes());
        System.out.println("Sent the client message");

        byte[] response = new byte[1024];
        in.read(response);
        String responseStr=new String(response).trim();
        System.out.println("Response from the server is : " + responseStr);

        sock.close();

    }

}
