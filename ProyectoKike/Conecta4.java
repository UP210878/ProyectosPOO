import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
    
public class Conecta4 extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean[][] isOccupied; // Para rastrear si una celda está ocupada
    private char currentPlayer;
    private JLabel statusLabel;
    public Color fontColorButton = new Color(255, 255, 255);
    public int rows = 6;
    public int cols = 7;

    public Conecta4() {
        setLayout(null);

        buttons = new JButton[rows][cols];
        isOccupied = new boolean[rows][cols];
        currentPlayer = 'X';

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("Turno del Jugador " + currentPlayer);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setForeground(fontColorButton);
        statusLabel.setBounds(5, 5, 300, 20);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel);

        int buttonSize = 80; // Tamaño de los botones
        int xOffset = 20; // Desplazamiento en el eje X
        int yOffset = 40; // Desplazamiento en el eje Y

        

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 48));
                buttons[i][j].setForeground(fontColorButton);
                buttons[i][j].setBackground(new Color(50, 50, 50));
                buttons[i][j].setBounds(xOffset + j * buttonSize, yOffset + i * buttonSize, buttonSize, buttonSize);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFocusPainted(false);
                add(buttons[i][j]);
                isOccupied[i][j] = false; // Todas las celdas están inicialmente desocupadas
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();

        int col = -1;

        for (int j = 0; j < cols; j++) {
            if (buttons[0][j] == buttonClicked) {
                col = j;
                break;
            }
        }

        if (col == -1 || isOccupied[0][col]) {
            return; // Columna llena o no válida
        }

        // Encuentra la fila disponible para colocar la ficha
        int row = -1;
        for (int i = rows - 1; i >= 0; i--) {
            if (!isOccupied[i][col]) {
                row = i;
                break;
            }
        }

        // Actualiza el estado y la apariencia del tablero
        isOccupied[row][col] = true;
        buttons[row][col].setText(String.valueOf(currentPlayer));
        System.out.println("'"+buttons[row][col].getText()+"'");

        if (checkWin(row, col, currentPlayer)) {
            statusLabel.setText("Jugador " + currentPlayer + " gana!");
            disableButtons();
        } else if (isBoardFull()) {
            statusLabel.setText("¡Empate!");
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText("Turno del Jugador " + currentPlayer);
        }
    }

    private boolean checkWin(int row, int col, char symbol) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                    if (buttons[i][j].getText().equals("X") || buttons[i][j].getText().equals("O")){
                        if (i+3<rows){
                            if (buttons[i][j].getText().equals(buttons[i+1][j].getText()) &&
                            buttons[i][j].getText().equals(buttons[i+2][j].getText()) &&
                            buttons[i][j].getText().equals(buttons[i+3][j].getText())){
                                return true;
                            }
                        }
                        if (j+3<cols){
                            if (buttons[i][j].getText().equals(buttons[i][j+1].getText()) &&
                            buttons[i][j].getText().equals(buttons[i][j+2].getText()) &&
                            buttons[i][j].getText().equals(buttons[i][j+3].getText())){
                                return true;
                            }
                        }
                        if (i+3<rows &&j+3<cols){
                            if (buttons[i][j].getText().equals(buttons[i+1][j+1].getText()) &&
                            buttons[i][j].getText().equals(buttons[i+2][j+2].getText()) &&
                            buttons[i][j].getText().equals(buttons[i+3][j+3].getText())){
                                return true;
                            }
                        }
                        if (i-3>0 &&j+3<cols){
                            if (buttons[i][j].getText().equals(buttons[i-1][j+1].getText()) &&
                            buttons[i][j].getText().equals(buttons[i-2][j+2].getText()) &&
                            buttons[i][j].getText().equals(buttons[i-3][j+3].getText())){
                                return true;
                            }
                        }
                    }
                }
                }
        // Implementa la lógica para verificar una victoria
        // Puedes usar código similar al proporcionado en la respuesta anterior
        return false;
    }

    private boolean isBoardFull() {
        for (int j = 0; j < cols; j++) {
            if (!isOccupied[0][j]) {
                return false;
            }
        }
        return true;
    }

    private void disableButtons() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String arg[]) {
        SwingUtilities.invokeLater(() -> {
            Conecta4 connect4Game = new Conecta4();
            connect4Game.setSize(700, 600); // Establece el tamaño de la ventana
            connect4Game.setVisible(true);
            connect4Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            connect4Game.setResizable(false);
            connect4Game.setTitle("Conecta 4");
            connect4Game.setLocationRelativeTo(null);
            connect4Game.getContentPane().setBackground(new Color(0, 0, 0));
        });
    }
}
