import java.net.Socket;
import java.io.IOException;

public class ClienteSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",12345);
            System.out.println("Conectado al servidor");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
