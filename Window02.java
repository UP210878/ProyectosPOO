import java.awt.Color;
import java.awt.Taskbar;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Window02 extends JFrame{
    public Window02(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        setBounds(0, 0, 450, 450);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setTitle("First Window");
        getContentPane().setBackground(new Color (0,0,0));
        setIconImage(new ImageIcon(getClass().
        getResource("images/page_link.png")).getImage());
}

public static void main(String[] args) {
    Window02 firstWindow = new Window02();
}
}