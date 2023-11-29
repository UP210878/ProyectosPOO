package ThreadsEjercicios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PongGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new PongFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class Paddle {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 80;
    private static final int SPEED = 2;

    private double x;
    private double y;
    private double dy;
    private boolean cursorMoving;

    public Paddle() {
        x = 0;
        y = 0;
        dy = 0;
        cursorMoving = false;
    }

    public void move() {
        if (cursorMoving) {
            y += dy;
        }
    }

    public void setDy(double dy) {
        this.dy = dy;
        cursorMoving = true;
    }

    public void stopMoving() {
        cursorMoving = false;
    }

    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void resetPosition() {
        setPosition(0, 0);
    }
}

class PongPanel extends JPanel {
    private Paddle paddle;
    public Pelota ball;
    private int resetCount;

    public PongPanel() {
        paddle = new Paddle();
        ball = new Pelota(getWidth() / 2, getHeight() / 2, this);
        resetCount = 0;
        addMouseListener(new PaddleMouseListener());
        addMouseMotionListener(new PaddleMouseListener());
        Timer timer = new Timer(20, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    public void movePaddle() {
        paddle.move();
    }

    public void moveBall() {
        ball.mueve_pelota(getBounds());
    }

    public void resetGame() {
        resetCount++;
    }

    public void checkCollision() {
        if (ball.getShape().intersects(paddle.getBounds())) {
            ball.invertDirection();
        }
    }

    public void update() {
        movePaddle();
        moveBall();
        checkCollision();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(paddle.getBounds());
        g2.fill(ball.getShape());
        g2.drawString("Resets: " + resetCount, getWidth() - 80, 20);
    }

    private class PaddleMouseListener extends MouseAdapter {
        public void mouseMoved(MouseEvent e) {
            paddle.setDy(e.getY() - paddle.getBounds().getCenterY());
        }

        public void mouseExited(MouseEvent e) {
            paddle.stopMoving();
        }
    }

}

class PongFrame extends JFrame {
    private PongPanel pongPanel;

    public PongFrame() {
        setBounds(600, 300, 400, 350);
        setTitle("Pong Game");

        pongPanel = new PongPanel();
        add(pongPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Exit", e -> System.exit(0));

        // Add "Dale!" button to start the game
        addButton(buttonPanel, "Dale!", e -> pongPanel.ball.startGame());

        add(buttonPanel, BorderLayout.SOUTH);

        
    }

    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        button.addActionListener(listener);
        container.add(button);
    }
}

class Pelota {
    private static final int TAMX = 10;
    private static final int TAMY = 10;
    private double x;
    private double y;
    private double dx = 3;
    private double dy = 3;
    private PongPanel pongPanel;
    private boolean gameStarted;

    public Pelota(double x, double y, PongPanel pongPanel) {
        this.x = x;
        this.y = y;
        this.pongPanel = pongPanel;
        this.gameStarted = false;
    }

    public void mueve_pelota(Rectangle2D limits) {
        // If the game is started, move the ball
        if (gameStarted) {
            x += dx;
            y += dy;

            if (x < limits.getMinX()) {
                x = limits.getCenterX();
                y = limits.getCenterY();
                pongPanel.resetGame();
            } else if (x + TAMX >= limits.getMaxX()) {
                dx = -dx;
            }

            if (y < limits.getMinY() || y + TAMY >= limits.getMaxY()) {
                dy = -dy;
            }
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    public void invertDirection() {
        dx = -dx;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        gameStarted = true;
    }
}
