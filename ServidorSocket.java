import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); //Puerto de escucha
            System.out.println("Esperando Conexion");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            //Realizar operaciones de lectura/escritura aqui

            socket.close(); //Cerrar el socket
            serverSocket.close(); //Cerrar el serveidor
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
