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
        show();
    }

    public void paint(Graphics g){
        int puntosX[] = {55,67,109,73,83,55,27,37,1,43};
        int puntosY[] = {0,36,36,54,96,72,96,54,36,36};

        Graphics2D g2d = (Graphics2D) g;

        GeneralPath estrella = new GeneralPath();

        estrella.moveTo(puntosX[0],puntosY[0]);
        for (int k = 1; k < puntosX.length; k++) {
            estrella.lineTo(puntosX[k],puntosY[k]);
        }
        estrella.closePath();

        g2d.translate(200,200);

        for (int j = 1; j <= 20; j++) {
            g2d.rotate(Math.PI/10.0);
            g2d.setColor(new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256)));
            g2d.fill(estrella);
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


