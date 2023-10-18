import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.RenderingHints.Key;

public class Window07 extends JFrame implements ActionListener{
    private JTextField textField1;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JButton button1,buttonCloseWindow;
    
    String texto = "";

    public Window07(){
        setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(10, 10, 200, 30);
        add(textField1);
        
        textArea1 = new JTextArea();
        scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(10, 50, 400, 300);
        add(scrollPane1);

        button1 = new JButton("Agregar");
        button1.setBounds(250, 10, 100, 30);
        add(button1);
        button1.addActionListener(this);
        buttonCloseWindow = new JButton("Salir");
        buttonCloseWindow.setBounds(300, 370, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);

    }    


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button1){
            texto = textField1.getText() + "\n";
            textArea1.append(texto);
            textField1.setText("");
        }
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
        Window07 formulario = new Window07();
        formulario.setBounds(0, 0, 450, 450);
        formulario.setVisible(true);
        formulario.setResizable(false);
        formulario.setLocationRelativeTo(null);
        formulario.setTitle("First Window");
        formulario.getContentPane().setBackground(new Color(200,200,200));
    }
}
