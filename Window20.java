import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.lang.*;

public class Window20 extends JFrame{
    private JLabel Title,data1,data2,data3,data4,data5,data6;
    public Window20(){
        super("Dibujando arcos");
        setSize(1000,1000);
        show();
    }

    public void paint(Graphics graph){
        int total = 360;
        long circulo = (Math.round(total*.5356));
        int valorarco = (int)circulo;
//Distribucion por sexo
        graph.setColor(new Color(200,0,0));
        graph.fillArc(50, 75, 200, 200, 90, (int)(Math.round(total*.5356)));
        graph.setColor(new Color(0,150,220));
        graph.fillArc(50, 75, 200, 200, 90+(int)(Math.round(total*.5356)), 360-(int)(Math.round(total*.5356)));

//Distribucion por edad

        graph.setColor(new Color(0,200,180));
        graph.fillArc(500, 75, 200, 200, 90, (int)(Math.round(total*.2373)));
        graph.setColor(new Color(150,100,220));
        graph.fillArc(500, 75, 200, 200, 90+(int)(total*.2373), (int)(total*.1709));
        graph.setColor(new Color(200,220,0));
        graph.fillArc(500, 75, 200, 200, 90+(int)(total*.2373)+(int)(total*.1709), (int)(total*.1909));
        graph.setColor(new Color(200,20,20));
        graph.fillArc(500, 75, 200, 200, 90+(int)(total*.2373)+(int)(total*.1709)+(int)(total*.1909),(int)(total*.2387));
        graph.setColor(new Color(0,20,200));
        graph.fillArc(500, 75, 200, 200, 90+(int)(total*.2373)+(int)(total*.1709)+(int)(total*.1909)+(int)(total*.2387),(int)(total*.1702));

//Distribucion por estrato
        graph.setColor(new Color(240,220,0));
        graph.fillArc(50, 375, 200, 200, 90,(int)(total*.0279));
        graph.setColor(new Color(0,150,220));
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279), (int)(total*.0445));
        graph.setColor(new Color(200,100,220));
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279)+(int)(total*.0445),(int)(total*.1243));
        graph.setColor(new Color(200,250,0));
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279)+(int)(total*.0445)+(int)(total*.1243),(int)(total*.3226));
        graph.setColor(new Color(200,20,20));
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279)+(int)(total*.0445)+(int)(total*.1243)+(int)(total*.3226),(int)(total*.3327));
        graph.setColor(new Color(0,100,200));
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279)+(int)(total*.0445)+(int)(total*.1243)+(int)(total*.3226)+(int)(total*.3327),(int)(total*.158));
//Distribucion por nivel educativo
        graph.setColor(new Color(150,100,220));
        graph.fillArc(500, 375, 200, 200, 90, (int)(total*.1843));
        graph.setColor(new Color(150,220,20));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843), (int)(total*.2028));
        graph.setColor(new Color(220,50,50));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843)+(int)(total*.2028),(int)(total*.3701));
        graph.setColor(new Color(0,100,220));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843)+(int)(total*.2028)+(int)(total*.3701),(int)(total*.2507));
    
    }

    public static void main(String[] args) {
        Window20 app = new Window20();
        app.addWindowListener(
            new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
