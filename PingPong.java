import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PingPong {
    public static void main (String[] args) {

        JFrame frame= new FrameBounce();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class BallThreads implements Runnable {
    public BallThreads(Ball aBall, Component aComponent) {
        ball = aBall;
        component = aComponent;
    }

    public void run () {
        for(int i=1; i<=3000; i++ ) {
            ball.move_ball(component.getBounds());
            component.paint(component.getGraphics());
            try {
                Thread.sleep(4);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Ball ball;
    private Component component;
}

class Ball {

    public void move_ball(Rectangle2D limits) {

        x+=dx;
        y+=dy;

        if(x<limits.getMinX()) {
            x=limits.getMinX();
            dx= -dx;
        }

        if(x+TAMX>=limits.getMaxX()) {
            x=limits.getMaxX() - TAMX;
            dx= -dx;
        }

        if(y<limits.getMinY()) {
            y=limits.getMinY();
            dy= -dy;
        }

        if(y+TAMY>=limits.getMaxY()) {
            y=limits.getMaxY() - TAMY;
            dy= -dy;
        }

    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x,y,TAMX,TAMY);
    }

    private static final int TAMX=10;
    private static final int TAMY=10;

    private double x=0;
    private double y=0;
    private double dx=1;
    private double dy=1;
}

class BallLeaf extends JPanel {
    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;

        for(Ball b: balls) {
            g2.fill(b.getShape());
        }
    }

    private ArrayList<Ball> balls=new ArrayList<Ball>();
}

class FrameBounce extends JFrame {
    public FrameBounce() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");

        leaf = new BallLeaf();

        add(leaf, BorderLayout.CENTER);

        JPanel BallLeaf = new JPanel();

        ponerBoton(BallLeaf, "Dale", new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                starts_the_game();
            }
        });

        ponerBoton(BallLeaf, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        add(BallLeaf, BorderLayout.SOUTH);
    }

    public void ponerBoton (Container c, String title, ActionListener listener) {

        JButton button =new JButton(title);
        c.add(button);

        button.addActionListener(listener);
    }

    public void starts_the_game () {
        Ball ball=new Ball();
        leaf.add(ball);
        Runnable r= new BallThreads(ball, leaf);
        Thread t = new Thread(r);
        t.start();
    }
    private BallLeaf leaf;
}