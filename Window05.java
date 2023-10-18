import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Window05 extends JFrame implements ActionListener{
    
    private JTextField textField1;
    private JLabel label1;
    private JButton buttonAddText, buttonCloseWindow;

    public Window05(){
        setLayout(null);
        label1 = new JLabel("Usuario:");
        label1.setBounds(10, 10, 100, 30);
        add(label1);

        textField1 = new JTextField();
        textField1.setBounds(120, 17, 150, 20);
        add(textField1);

        buttonAddText = new JButton("Aceptar");
        buttonAddText.setBounds(10, 50, 100, 30);
        add(buttonAddText);
        buttonAddText.addActionListener(this);

        buttonCloseWindow = new JButton("Salir");
        buttonCloseWindow.setBounds(100, 50, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonAddText){
            String texto = textField1.getText();
            setTitle(texto);
        }
        if (e.getSource() == buttonCloseWindow){
            label1.setText("Has presionado Salir");
            int respuesta = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
            
        }
    }

    public static void main(String[] args) {
        
        Window05 formulario = new Window05();

        formulario.setBounds(0, 0, 450, 180);
        formulario.setVisible(true);
        formulario.setResizable(false);
        formulario.setLocationRelativeTo(null);
        formulario.setTitle("First Window");
        formulario.getContentPane().setBackground(new Color(250,250,250));
    }
}


