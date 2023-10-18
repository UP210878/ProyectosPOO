import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Window06 extends JFrame implements ActionListener{
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton buttonCloseWindow;
    
    public Window06(){
        setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(10, 10, 200, 30);
        add(textField1);

        textArea1 = new JTextArea();
        textArea1.setBounds(10, 50, 400, 200);
        add(textArea1);

        buttonCloseWindow = new JButton("Salir");
        buttonCloseWindow.setBounds(300, 370, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);
    }    


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonCloseWindow){
            int respuesta = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
            
        }
    }

    public static void main(String[] args) {
        Window09 formulario = new Window09();
        formulario.setBounds(0, 0, 450, 450);
        formulario.setVisible(true);
        formulario.setResizable(false);
        formulario.setLocationRelativeTo(null);
        formulario.setTitle("First Window");
        formulario.getContentPane().setBackground(new Color(200,200,200));
    }
}
