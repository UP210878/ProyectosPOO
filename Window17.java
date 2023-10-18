import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Window17 extends JFrame{
    public Window17(){
        super("Dibujando figuras en 2D");
        setSize(425, 170);
        show();
    }

    public void paint (Graphics g){
        Graphics2D graf2d = (Graphics2D) g;

        graf2d.setPaint(new GradientPaint(5, 30, Color.blue, 35, 100, Color.yellow,true));
        graf2d.fill(new Ellipse2D.Double(5,40,65,100));

        graf2d.setPaint(Color.red);
        graf2d.setStroke(new BasicStroke(10.0f));
        graf2d.draw(new Rectangle2D.Double(80, 40, 65, 100));

        
    }

    public static void main(String[] args) {
        Window17 app = new Window17();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
