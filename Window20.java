import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Window20 extends JFrame{
    public Window20(){
        super("Distribuciones");
        setSize(1000,600);
        setVisible(true);
    }

    public void paint(Graphics graph){
        int total = 360;
        Color[] colors ={
            new Color(0,150,220),
            new Color(200,0,0),
            new Color(200,250,0),
            new Color(200,100,220),
            new Color(0,200,180),
            new Color(240,220,0),
        };
        int angle = 90;
        int circleWidth=200;
        int circleHeight=200;

        graph.setFont(new Font("Arial",Font.PLAIN,16));
        graph.drawString("Hombre 53.65%",280 , 160);
        graph.drawString("Mujer 46.35%",280 , 190);

        graph.drawString("1",280 , 420);
        graph.drawString("2",280 , 450);
        graph.drawString("3",280 , 480);
        graph.drawString("4",280 , 510);
        graph.drawString("5",280 , 540);
        graph.drawString("6",280 , 570);

        graph.drawString("18-24",750 , 130);
        graph.drawString("25-34",750 , 160);
        graph.drawString("35-44",750 , 190);
        graph.drawString("45-54",750 , 220);
        graph.drawString("55+",750 , 250);

        graph.drawString("Sin bachillerato",750 , 450);
        graph.drawString("Bach/Lic",750 , 480);
        graph.drawString("Tecnico",750 , 510);
        graph.drawString("Otros",750 , 540);

        

        graph.setColor(colors[1]);
        graph.fillRect(265, 150, 10, 10);
        graph.setColor(colors[0]);
        graph.fillRect(265, 180, 10, 10);

        graph.setColor(colors[0]);
        graph.fillRect(265, 410, 10, 10);
        graph.setColor(colors[1]);
        graph.fillRect(265, 440, 10, 10);
        graph.setColor(colors[2]);
        graph.fillRect(265, 470, 10, 10);
        graph.setColor(colors[3]);
        graph.fillRect(265, 500, 10, 10);
        graph.setColor(colors[4]);
        graph.fillRect(265, 530, 10, 10);
        graph.setColor(colors[5]);
        graph.fillRect(265, 560, 10, 10);

        graph.setColor(colors[0]);
        graph.fillRect(730, 120, 10, 10);
        graph.setColor(colors[1]);
        graph.fillRect(730, 150, 10, 10);
        graph.setColor(colors[2]);
        graph.fillRect(730, 180, 10, 10);
        graph.setColor(colors[3]);
        graph.fillRect(730, 210, 10, 10);
        graph.setColor(colors[4]);
        graph.fillRect(730, 240, 10, 10);

        graph.setColor(colors[0]);
        graph.fillRect(730, 440, 10, 10);
        graph.setColor(colors[1]);
        graph.fillRect(730, 470, 10, 10);
        graph.setColor(colors[2]);
        graph.fillRect(730, 500, 10, 10);
        graph.setColor(colors[3]);
        graph.fillRect(730, 530, 10, 10);

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por Sexo",40 , 60);
        for (int i = 0; i <= 1; i++) {
            int positionX=50;
            int positionY=75;
            double[] values ={.5365,.4635};
            int fillUpAngle = (int)(Math.round(total*values[i]));
            graph.setColor(colors[values.length-1-i]);
            graph.fillArc(positionX,positionY,circleWidth,circleHeight,angle,fillUpAngle);
            angle = angle+fillUpAngle;
        }

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("53.65%",70 , 190);
        graph.drawString("46.35%",170 , 180);
        

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por edad",500 , 60);
        for (int i = 0; i <= 4; i++) {
            double[] values ={.2373,.1709,.1909,.2387,.1622};
            int fillUpAngle = (int)(Math.round(total*values[i]));
            graph.setColor(colors[values.length-1-i]);
            graph.fillArc(500,75,200,200,angle,fillUpAngle);
            angle = angle+fillUpAngle;
        }

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("23.73%",520 , 140);
        graph.drawString("17.09%",510 , 210);
        graph.drawString("19.09%",570 , 260);
        graph.drawString("23.87%",620 , 200);
        graph.drawString("16.22%",610 , 130);

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por estrato",40 , 360);
        for (int i = 0; i <= 5; i++) {
            double[] values ={.0279,.0445,.1243,.3226,.3327,.1480};
            int fillUpAngle = (int)(Math.round(total*values[i]));
            graph.setColor(colors[values.length-1-i]);
            graph.fillArc(50,375,200,200,angle,fillUpAngle);
            angle = angle+fillUpAngle;
        }
        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("2.79%",120 , 375);
        graph.drawString("4.45%",60 , 380);
        graph.drawString("12.43%",65 , 440);
        graph.drawString("32.26%",75 , 520);
        graph.drawString("33.27%",170 , 500);
        graph.drawString("14.80%",155 , 420);

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por nivel",480 , 330);
        graph.drawString("educativo",540 , 360);
        for (int i = 0; i <= 3; i++) {
            double[] values ={.1834,.2028,.3701,.2437};
            int fillUpAngle = (int)(Math.round(total*values[i]));
            graph.setColor(colors[values.length-1-i]);
            graph.fillArc(500,375,200,200,angle,fillUpAngle);
            angle = angle+fillUpAngle;
        }

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("18.43%",525 , 430);
        graph.drawString("20.28%",510 , 490);
        graph.drawString("37.01%",600 , 520);
        graph.drawString("24.37%",610 , 440);
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
