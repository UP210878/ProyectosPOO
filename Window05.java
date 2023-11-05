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
            String text = textField1.getText();
            setTitle(text);
        }
        if (e.getSource() == buttonCloseWindow){
            label1.setText("Has presionado Salir");
            int response = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
            
        }
    }

    public static void main(String[] args) {
        
        Window05 Window = new Window05();

        Window.setBounds(0, 0, 450, 180);
        Window.setVisible(true);
        Window.setResizable(false);
        Window.setLocationRelativeTo(null);
        Window.setTitle("First Window");
        Window.getContentPane().setBackground(new Color(250,250,250));
    }
}


