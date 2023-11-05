import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Window18 extends JFrame{
    public Window18()
    {
        super("Dibujando figuras en 2D");
        setBackground(Color.black);
        setSize(425, 400);
        setVisible(true);
    }

    public void paint(Graphics g){
        int cornersX[] = {55,67,109,73,83,55,27,37,1,43};
        int cornersY[] = {0,36,36,54,96,72,96,54,36,36};

        Graphics2D g2d = (Graphics2D) g;

        GeneralPath star = new GeneralPath();

        star.moveTo(cornersX[0],cornersY[0]);
        for (int k = 1; k < cornersX.length; k++) {
            star.lineTo(cornersX[k],cornersY[k]);
        }
        star.closePath();

        g2d.translate(200,200);

        for (int j = 1; j <= 20; j++) {
            g2d.rotate(Math.PI/10.0);
            g2d.setColor(new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256)));
            g2d.fill(star);
        }   
    }

    public static void main(String[] args) {
        Window18 app = new Window18();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}


