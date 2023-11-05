import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window16 extends JFrame{
    public Window16(){
        super("Dibujando Poligonos");
        setSize(275,230);
        setVisible(true);
    }
    public void paint(Graphics graph){
        int X[] = {20,40,50,30,20,15};
        int Y[] = {50,50,60,80,80,60};
        Polygon poli1 = new Polygon(X,Y,6);
        
        graph.drawPolygon(poli1);

        int X2[] = {70,90,100,80,70,65,60};
        int Y2[] = {100,100,110,110,130,110,90};

        graph.drawPolyline(X2, Y2, 7);

        int X3[] = {120,140,150,190};
        int Y3[] = {40,70,80,60};

        graph.fillPolygon(X3, Y3, 4);

        Polygon poli2 = new Polygon();
        poli2.addPoint(165,135);
        poli2.addPoint(175,150);
        poli2.addPoint(270,200);
        poli2.addPoint(200,220);
        poli2.addPoint(130,180);

        graph.fillPolygon(poli2);
    }

    public static void main(String[] args) {
        Window16 app = new Window16();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
