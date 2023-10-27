import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Window21 extends JFrame{
    public Window21()
    {
        super("Uso de colores");

        setSize(1500,880);
        show();

    }
    public void paint(Graphics graph){
        Color colores[]={
            new Color(0, 100, 200),
            new Color(200, 0, 0),
            new Color(0, 200, 100),
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
            {1,2,3},
            {1,2,6},
            {2,3,1},
            {6,4,2},
            {6,8,7},
            {7,3,4},
            {9,2,1},
            {5,6,3},
            {1,2,4},
            {2,3,4},
            {5,4,3},
            {1,2,3},
        };
        int X = 100;
        int Y = 300;
        for (int i = 0; i < 12; i++) {
            int posX = X+(i*100);
            int posY = Y;
            int siguienterect = 0;
            graph.setColor(Color.black);
            graph.drawString(meses[i], X+(i*100),600);
            for (int j = 0; j < 3; j++) {
                graph.setColor(colores[j]);
                graph.fillRect(posX, 550-siguienterect, 30, valores[i][j]*5);
                siguienterect=+valores[i][j]*5;
            }
        }

        graph.setColor(new Color(255, 0, 0));
        graph.fillRect(25, 50, 100, 20);
        graph.drawString("RVA actual: " + graph.getColor(),130 , 40);

        graph.setColor(new Color(0.0f, 1.0f, 0.0f));
        graph.fillRect(25, 75, 100, 20);
        graph.drawString("RVA actual: " + graph.getColor(),130 , 65);

        graph.setColor(Color.blue);
        graph.fillRect(25, 100, 100, 20);
        graph.drawString("RVA actual: " + graph.getColor(),130 , 90);

        Color color = Color.magenta;
        graph.setColor(color);
        graph.fillRect(25, 125, 100, 20);
        graph.drawString("RVA actual: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue(), 130 , 115);
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
