import java.awt.Color;
import javax.swing.JFrame;

public class Window01 extends JFrame {
    public static void main(String[] args) {
        Window01 firstWindow = new Window01();
        firstWindow.setBounds(0, 0, 450, 450);
        firstWindow.setVisible(true);
        firstWindow.setResizable(false);
        firstWindow.setLocationRelativeTo(null);
        firstWindow.setTitle("First Window");
        firstWindow.getContentPane().setBackground(new Color (0,0,0));
    }
}
