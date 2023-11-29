import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.io.DataOutputStream;

public class ClienteTCP extends Frame implements ActionListener{
    Panel panel;
    Socket conexion;
    TextField textent,textsal,puertoField;
    Button enviar,conectar,desconectar;
    DataOutputStream salida;
    DataInputStream entrada;
    ClienteTCP(String nombre)
    {
        super(nombre);
        setSize(350,200);
        panel=new Panel();
        textsal=new TextField(40);
        textent=new TextField(40);
        puertoField = new TextField(5);
        panel.add(new Label("Puerta del servidor"));
        panel.add(puertoField);
        textent.setText("Pula el boton \"Conectar\" para conectarte");
        textent.setEditable(false);
        enviar=new Button("Enviar");
        enviar.setEnabled(false);
        conectar=new Button("Conectar");
        desconectar=new Button("Desconectar");
        desconectar.setEnabled(false);
        panel.add(new Label("Datos a enviar"));
        panel.add(textsal);
        panel.add(new Label("Datos recibidos"));
        panel.add(textent);
        panel.add(enviar);
        panel.add(conectar);
        panel.add(desconectar);
        enviar.addActionListener(this);
        conectar.addActionListener(this);
        desconectar.addActionListener(this);
        addWindowListener(new Cerrar());
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String com=e.getActionCommand();
        if (com.equals("Conectar")){
            try {
                String host = "localhost";
                int puerto = Integer.parseInt(puertoField.getText());
                conexion = new Socket(host,puerto);
            } catch (IOException exception) {}
        }
        if (com.equals("Enviar")){
            try {
                textent.setText("lo que sea");
                salida.writeUTF(textsal.getText());
                textent.setText(entrada.readUTF());
                textsal.setText("");
            } catch (IOException exception) {}
        }
        else
            try {
                salida.writeUTF("Salir");
                conexion.close();
                conectar.setEnabled(true);
                desconectar.setEnabled(false);
                enviar.setEnabled(false);
                textent.setText("Pulsa el boton \"Conectar\" para conectarte");
            } catch (IOException exception) {}
    }
    class Cerrar extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            dispose();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new ClienteTCP("Cliente Angel");
        new ClienteTCP("Cliente Pepe");
    }
}
