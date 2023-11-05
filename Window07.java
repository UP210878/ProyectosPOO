import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

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
            int response = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
            
        }
    }

    public static void main(String[] args) {
        Window07 addTextWindow = new Window07();
        addTextWindow.setBounds(0, 0, 450, 450);
        addTextWindow.setVisible(true);
        addTextWindow.setResizable(false);
        addTextWindow.setLocationRelativeTo(null);
        addTextWindow.setTitle("First Window");
        addTextWindow.getContentPane().setBackground(new Color(200,200,200));
    }
}
