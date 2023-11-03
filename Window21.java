import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
public class Window21 extends JFrame{
    public Window21()
    {
        super("Uso de colores");

        setSize(1500,880);
        show();

    }
    public void paint(Graphics graph){
        Color colores[]={
            new Color(0, 200, 100), // Verde
            new Color(200, 0, 0), // Rojo
            new Color(0, 100, 200), // Azul
        };
        String meses[] = {
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre",
        };
        int valores[][]={
            {272,128,265},
            {271,186,170},
            {292,168,196},
            {192,240,203},
            {105,265,169},
            {217,127,146},
            {269,218,227},
            {293,135,195},
            {125,137,172},
            {258,263,287},
            {264,266,244},
            {292,237,165},
        };

        Graphics2D g2d = (Graphics2D) graph;
        
        int X = 100;
        int Y = 300;

        //VENTAS DEL ANO EN MILES
        graph.drawRect(80, 40, 1250, 700);
        graph.setFont(new Font("Arial", 1, 20));
        graph.drawString("Ventas del año por miles", 1250/2, 70);
        graph.setFont(new Font("Arial", 1, 15));
        for (int i = 0; i < 10; i++) {
            graph.drawLine(X, 550-(i*50), 1250, 550-(i*50));
            graph.drawString(" " + String.valueOf(i*100), 1250, 550-(i*50));
        }
        for (int i = 0; i < 3; i++) {
            graph.setColor(colores[2-i]);
            graph.fillRect((1250/3)+i*200, 670, 10, 10);
            graph.setColor(Color.black);
            graph.drawString("Sucursal " + String.valueOf(i+1), (1350/3)+i*200, 680); 
        }


        g2d.setColor(Color.black);
        Font font = new Font(null,Font.BOLD,14);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-45),0,0);
        Font rotatedFont = font.deriveFont(affineTransform);
        
        for (int i = 0; i < 12; i++) {
            int posX = X+(i*100);
            graph.setColor(Color.black);
            g2d.setFont(rotatedFont);
            g2d.drawString(meses[i], X+(i*100),620);
            int maxHeight = (int)(Math.round((valores[i][0]+valores[i][1]+valores[i][2])*.5));
            for (int j = 0; j < 3; j++) {
                graph.setFont(new Font("Arial", 1, 16));
                graph.setColor(colores[j]);
                graph.fillRect(posX, 550-maxHeight, 40, (int)(Math.round(valores[i][j]*.5)));
                graph.setColor(Color.black);
                graph.drawString(String.valueOf((valores[i][j])), posX+2, (int)((550-maxHeight)+(Math.round(valores[i][j]/4))));
                maxHeight-=(int)(Math.round(valores[i][j]*.5));

                
            }
        }
    }

    public static void main(String[] args) {
        Window21 app = new Window21();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });
    }
}
