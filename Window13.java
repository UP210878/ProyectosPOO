import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Window13 extends JFrame{
    public Window13()
    {
        super("Uso de colores");

        setSize(400,180);
        show();

    }
    public void paint(Graphics graph){
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
        Window13 app = new Window13();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });
    }
}
