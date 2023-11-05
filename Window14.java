import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window14 extends JFrame{
    private String u = "Utilizando drawString!";
    public Window14(){
        super("Dibujando lineas, rectangulos y elipses");
        setSize(400,165);
        setVisible(true);
    }    
    public void paint (Graphics graph){
        graph.setColor(Color.red);
        graph.drawLine(10, 35, 300, 35);

        graph.setColor(Color.blue);
        graph.drawRect(5, 40, 90, 55);
        graph.fillRect(100, 40, 90, 55);

        graph.setColor(Color.cyan);
        graph.fillRoundRect(195, 40, 90, 55, 50, 50);
        graph.drawRoundRect(290, 40, 90, 55, 20, 20);

        graph.setColor(Color.yellow);
        graph.draw3DRect(5, 100, 90, 55, true);
        graph.fill3DRect(100, 100, 90, 55, true);

        graph.setColor(Color.magenta);
        graph.drawOval(195, 100, 90, 55);
        graph.fillOval(290, 100, 90, 55);
    }

    public static void main(String[] args) {
        Window14 app = new Window14();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
