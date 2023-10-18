import java.awt.Color;
import java.awt.Font;
import java.awt.Taskbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Window03 extends JFrame implements ActionListener{

    private JButton buttonCloseWindow;

    public Window03(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        setBounds(0, 0, 450, 450);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setTitle("First Window");
        getContentPane().setBackground(new Color (50,50,50));

        setIconImage(new ImageIcon(getClass().getResource("images/page_link.png")).getImage());

        buttonCloseWindow = new JButton("Cerrar");
        buttonCloseWindow.setBounds(123, 280, 100,30);
        buttonCloseWindow.setSize(100, 30);;
        buttonCloseWindow.setBackground(new Color(200, 200, 200));
        buttonCloseWindow.setFont(new Font("Andale Mono", 1, 14));
        buttonCloseWindow.setForeground(new Color(0, 0, 0));
        buttonCloseWindow.addActionListener(this);
        add(buttonCloseWindow);
}

public static void main(String[] args) {
    Window04 firstWindow = new Window04();
}


@Override
public void actionPerformed(ActionEvent e){
    if (e.getSource() == buttonCloseWindow) {
        int respuesta = JOptionPane.showConfirmDialog
        (this, "Desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }
}
}
