import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Window19 extends JFrame{
    public Window19(){
        super("Dibujando arcos");
        setSize(300,300);
        show();
    }

    public void paint(Graphics graph){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < 13; k++) {
                    graph.setColor(new Color(i*18, j*18, k*18));
                    graph.fillArc(50, 55, 200, 200, (i+j+k)*10, 10);
                }
            }
        }
    }

    public static void main(String[] args) {
        Window19 app = new Window19();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
