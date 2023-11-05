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
//ETIQUETAS
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

        

        graph.setColor(new Color(200, 0, 0));
        graph.fillRect(255, 145, 20, 20);
        graph.setColor(new Color(0, 150, 220));
        graph.fillRect(255, 175, 20, 20);

        graph.setColor(new Color(0,100,200));
        graph.fillRect(265, 410, 10, 10);
        graph.setColor(new Color(200,20,20));
        graph.fillRect(265, 440, 10, 10);
        graph.setColor(new Color(200,250,0));
        graph.fillRect(265, 470, 10, 10);
        graph.setColor(new Color(200,100,220));
        graph.fillRect(265, 500, 10, 10);
        graph.setColor(new Color(0,150,220));
        graph.fillRect(265, 530, 10, 10);
        graph.setColor(new Color(240,220,0));
        graph.fillRect(265, 560, 10, 10);

        graph.setColor(new Color(0,100,200));
        graph.fillRect(730, 120, 10, 10);
        graph.setColor(new Color(200,20,20));
        graph.fillRect(730, 150, 10, 10);
        graph.setColor(new Color(200,220,0));
        graph.fillRect(730, 180, 10, 10);
        graph.setColor(new Color(150,100,220));
        graph.fillRect(730, 210, 10, 10);
        graph.setColor(new Color(0,200,180));
        graph.fillRect(730, 240, 10, 10);

        graph.setColor(new Color(0,100,220));
        graph.fillRect(730, 440, 10, 10);
        graph.setColor(new Color(220,50,50));
        graph.fillRect(730, 470, 10, 10);
        graph.setColor(new Color(150,220,20));
        graph.fillRect(730, 500, 10, 10);
        graph.setColor(new Color(150,100,220));
        graph.fillRect(730, 530, 10, 10);

        
        
//Distribucion por sexo

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por Sexo",40 , 60);
        /*
        graph.setColor(new Color(200,0,0));
        graph.fillArc(50, 75, 200, 200, 90, (int)(Math.round(total*.5356)));
        graph.setColor(new Color(0,150,220));
        graph.fillArc(50, 75, 200, 200, 90+(int)(Math.round(total*.5356)), 360-(int)(Math.round(total*.5356)));
        graph.setColor(Color.black);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("53.65%",70 , 190);
        graph.drawString("46.35%",170 , 180);*/

        Color[] Colores ={
            new Color(0,150,220),
            new Color(200,0,0),
            new Color(200,250,0),
            new Color(200,100,220),
            new Color(0,200,180),
            new Color(240,220,0),
        };
        int angulo = 90;
        for (int i = 0; i <= 1; i++) {
            double[] Valores ={.5365,.4635};
            int relleno = (int)(Math.round(total*Valores[i]));
            graph.setColor(Colores[1-i]);
            graph.fillArc(50,75,200,200,angulo,relleno);
            angulo = angulo+relleno;
        }


//Distribucion por edad
        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por edad",500 , 60);
/*
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
*/
        angulo = 90;
        for (int i = 0; i <= 4; i++) {
            double[] Valores ={.2373,.1709,.1909,.2387,.1622};
            int relleno = (int)(Math.round(total*Valores[i]));
            graph.setColor(Colores[4-i]);
            graph.fillArc(500,75,200,200,angulo,relleno);
            angulo = angulo+relleno;
        }

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("23.73%",520 , 140);
        graph.drawString("17.09%",510 , 210);
        graph.drawString("19.09%",570 , 260);
        graph.drawString("23.87%",620 , 200);
        graph.drawString("16.22%",610 , 130);


//Distribucion por estrato
        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por estrato",40 , 360);

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
        graph.fillArc(50, 375, 200, 200, 90+(int)(total*.0279)+(int)(total*.0445)+(int)(total*.1243)+(int)(total*.3226)+(int)(total*.3327),(int)(total*.155));


        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("2.79%",120 , 375);
        graph.drawString("4.45%",60 , 380);
        graph.drawString("12.43%",65 , 440);
        graph.drawString("32.26%",75 , 520);
        graph.drawString("33.27%",170 , 500);
        graph.drawString("14.80%",155 , 420);

        //Distribucion por nivel educativo
        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,20));
        graph.drawString("Distribución por nivel",480 , 330);
        graph.drawString("educativo",540 , 360);


        graph.setColor(new Color(150,100,220));
        graph.fillArc(500, 375, 200, 200, 90, (int)(total*.1843));
        graph.setColor(new Color(150,220,20));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843), (int)(total*.2028));
        graph.setColor(new Color(220,50,50));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843)+(int)(total*.2028),(int)(total*.3701));
        graph.setColor(new Color(0,100,220));
        graph.fillArc(500, 375, 200, 200, 90+(int)(total*.1843)+(int)(total*.2028)+(int)(total*.3701),(int)(total*.2507));

        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,16));
        graph.drawString("18.43%",525 , 430);
        graph.drawString("20.28%",510 , 490);
        graph.drawString("37.01%",600 , 520);
        graph.drawString("24.07%",610 , 440);
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
