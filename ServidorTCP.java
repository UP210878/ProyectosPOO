import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class ServidorTCP extends Frame{
    TextArea entrada;
    ServerSocket s;
    int clientes;
    ServidorTCP(){
        setTitle("Servidor");
        setSize(350,400);
        // entrada=new TextArea(20,40)
        entrada=new TextArea(20,40);
        entrada.setEditable(false);
        add(entrada);
        addWindowListener(new Cerrar());
        setVisible(true);
        clientes=0;
    }
    void lanzarServidor(){
        String cadena;
        try {
            s=new ServerSocket(5001,50);
            while (true)
            new NuevoCliente(s.accept(),this,clientes++).start();
        } catch (IOException e) {}
    }
    public void añadir(String texto){
        entrada.append(texto);
    }
    class Cerrar extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            dispose();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        ServidorTCP Servidor = new ServidorTCP();
        Servidor.lanzarServidor();
    }
}
class NuevoCliente extends Thread{
    Socket conexion;
    ServidorTCP serv;
    int cliente;
    DataInputStream entrada;
    DataOutputStream salida;
    NuevoCliente(Socket c,ServidorTCP s,int numero){
        conexion=c;
        serv=s;
        cliente=numero;
        try
        {
            entrada=new DataInputStream(conexion.getInputStream());
            salida=new DataOutputStream(conexion.getOutputStream());
        }
        catch(IOException e){}
    }
    public void run()
    {
        boolean Salir=false;
        serv.añadir("Cliente "+cliente+" se ha conectado\n");
        while (!Salir) {
            try {
                String cadena=entrada.readUTF();
                if (cadena.equals("Salir"))
                Salir = true;
                else {
                    serv.añadir("El cliente "+cliente+" ha enviado.\n"+cadena+"\n");
                    salida.writeUTF("Cadena \""+cadena+"\" recibida");
                }
            } catch (IOException e) {}
        }
        serv.añadir("Se ha ido el cliente "+cliente+"\n");
        try {
            conexion.close();
        } catch (IOException e) {}
    }
}

