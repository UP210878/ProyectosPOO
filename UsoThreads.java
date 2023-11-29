import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoThreads {
    public static void main(String[] args) {
        JFrame frame = new PingPongFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class PingPongBall implements Runnable {
    private Ball ball;
    private Component component;
    private Paddle paddle;
    private boolean gameOver;

    public PingPongBall(Ball aBall, Paddle aPaddle, Component aComponent) {
        ball = aBall;
        component = aComponent;
        paddle = aPaddle;
        gameOver = false;
    }

    public void run() {
        for (int i = 1; i > 0
         && !gameOver; i++) {
            ball.moveBall(component.getBounds());
            paddle.movePaddle(component.getBounds());

            if (ball.getShape().intersects(paddle.getShape())) {
                ball.reverseDirection();
            }

            if (ball.getShape().getMinX() <= 0) {
                // La pelota ha alcanzado la pared izquierda, mostrar mensaje de Game Over
                gameOver = true;
            }

            component.repaint(); // Repintar el componente en lugar de usar el método paint directamente
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (gameOver) {
            // Mostrar el mensaje de Game Over
            Graphics2D g2 = (Graphics2D) component.getGraphics();
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            String message = "Game Over";
            int messageWidth = g2.getFontMetrics().stringWidth(message);
            int x = (component.getWidth() - messageWidth) / 2;
            int y = component.getHeight() / 2;
            g2.drawString(message, x, y);
        }
    }
}

class Ball {
    private static final int TAMX = 10;
    private static final int TAMY = 10;

    private double x;
    private double y;
    private double dx = 1;
    private double dy = 1;

    public Ball(double initialX, double initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void moveBall(Rectangle2D limits) {
        x += dx;
        y += dy;

        if (x < limits.getMinX()) {
            x = limits.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limits.getMaxX()) {
            x = limits.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limits.getMinY()) {
            y = limits.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limits.getMaxY()) {
            y = limits.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    public void reverseDirection() {
        dx = -dx;
    }
}

class Paddle {
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 60;

    private double x = 0;
    private double y = 0;
    private double dy = 0;

    public void movePaddle(Rectangle2D limits) {
        y += dy;

        if (y < limits.getMinY()) {
            y = limits.getMinY();
        }

        if (y + PADDLE_HEIGHT >= limits.getMaxY()) {
            y = limits.getMaxY() - PADDLE_HEIGHT;
        }
    }

    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}

class PingPongPanel extends JPanel implements KeyListener {
    private ArrayList<Ball> balls = new ArrayList<>();
    private Paddle paddle;
    
    public PingPongPanel() {
        setBackground(Color.GREEN);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        paddle = new Paddle();
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Ball ball : balls) {
            g2.fill(ball.getShape());
        }

        g2.fill(paddle.getShape());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            paddle.setDy(-1);
        } else if (key == KeyEvent.VK_DOWN) {
            paddle.setDy(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            paddle.setDy(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this example
    }
}

class PingPongFrame extends JFrame {
    private PingPongPanel pingPongPanel;

    public PingPongFrame() {
        setBounds(600, 300, 400, 350);
        setTitle("Ping Pong");

        pingPongPanel = new PingPongPanel();
        add(pingPongPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        ponerBoton(buttonPanel, "Dale", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                startsTheGame();
            }
        });

        ponerBoton(buttonPanel, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);

        // Registrar el KeyListener en el JFrame
        addKeyListener(pingPongPanel);
    }

    public void ponerBoton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void startsTheGame() {
        Ball ball = new Ball(pingPongPanel.getWidth() - 20, 0);
        pingPongPanel.addBall(ball);

        Runnable ballRunnable = new PingPongBall(ball, pingPongPanel.getPaddle(), pingPongPanel);
        Thread ballThread = new Thread(ballRunnable);
        ballThread.start();

        // Solicitar el foco para que el panel pueda recibir eventos del teclado
        pingPongPanel.requestFocusInWindow();
    }
}