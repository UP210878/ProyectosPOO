import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window16 extends JFrame{
    public Window16(){
        super("Dibujando Poligonos");
        setSize(275,230);
        show();
    }
    public void paint(Graphics graph){
        int valoresX[] = {20,40,50,30,20,15};
        int valoresY[] = {50,50,60,80,80,60};
        Polygon poli1 = new Polygon(valoresX,valoresY,6);
        
        graph.drawPolygon(poli1);

        int valoresX2[] = {70,90,100,80,70,65,60};
        int valoresY2[] = {100,100,110,110,130,110,90};

        graph.drawPolyline(valoresX2, valoresY2, 7);

        int valoresX3[] = {120,140,150,190};
        int valoresY3[] = {40,70,80,60};

        graph.fillPolygon(valoresX3, valoresY3, 4);

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
