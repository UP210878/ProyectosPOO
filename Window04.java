import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Window04 extends JFrame implements ActionListener{

    private JButton button1, button2, buttonCloseWindow;
    private JLabel label1;

    public Window04(){
        setLayout(null);
        setIconImage(new ImageIcon(getClass().getResource("images/page_link.png")).getImage());

        button1 = new JButton("Boton 1");
        button1.setBounds(10, 100, 90, 30);
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Boton 2");
        button2.setBounds(110, 100, 90, 30);
        add(button2);
        button2.addActionListener(this);

        buttonCloseWindow = new JButton("Salir");
        buttonCloseWindow.setBounds(280, 100, 90, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);

        label1 = new JLabel("En espera...");
        label1.setBounds(10, 10, 300, 30);
        add(label1);
        
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button1){
            label1.setText("Has presionado el boton 1");
        }
        if (e.getSource() == button2){
            label1.setText("Has presionado el boton 2");
        }
        if (e.getSource() == buttonCloseWindow) {
            label1.setText("Has presionado salir");
            int response = JOptionPane.showConfirmDialog
            (this, "Desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        

        }
    }


    public static void main(String[] args) {
        
        Window04 Window = new Window04();

        Window.setBounds(0, 0, 450, 180);
        Window.setVisible(true);
        Window.setResizable(false);
        Window.setLocationRelativeTo(null);
        Window.setTitle("First Window");
        Window.getContentPane().setBackground(new Color (250,250,250));
    }
}



