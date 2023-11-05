import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Window11 extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;
    public Color fontColorButton = new Color(255,255,255);
    public Color fontColorButtonWin = new Color(255,0,0);
    public String match;


    public Window11(){
        setLayout(null);
        
        Color fontColorButton = new Color(255,255,255);
        buttons = new JButton[3][3];
        currentPlayer = 'X';

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("Turno del jugador " + currentPlayer);
        statusLabel.setBounds(5, 5, 315, 20);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setForeground(fontColorButton);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    buttons[i][j] = new JButton("");
                    buttons[i][j].setBounds((i*105)+10,(j*105)+50,100,100);
                    buttons[i][j].setFont(new Font("Arial",Font.BOLD,48));
                    buttons[i][j].setForeground(fontColorButton);
                    buttons[i][j].setBackground(new Color(50,50,50));
                    buttons[i][j].addActionListener(this);
                    add(buttons[i][j]);
            }
        }

    }

    public void actionPerformed(ActionEvent e){
        JButton buttonClicked = (JButton) e.getSource();

        if(!buttonClicked.getText().equals("")){
            return;
        }

        buttonClicked.setText(String.valueOf(currentPlayer));


        if (checkWin()){
            statusLabel.setText("Jugador" + currentPlayer + "gana!");
            disableButtons();
        }else if (isBoardFull()){
            statusLabel.setText("Empate");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setBackground(new Color(255,255,255));
                }
            }
        }else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText("Turno del jugador" + currentPlayer);
        }
    }

    private boolean checkWin(){
        String[] board = new String[9];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[index++] = buttons[i][j].getText();
            }
        }

        for (int i = 0; i < 8; i++) {
            String line = "";
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    match ="012";
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    match ="345";
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    match ="678";
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    match ="036";
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    match ="147";
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    match ="258";
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    match ="048";
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    match ="246";
                    break;
            }

            if (line.equals("XXX") || line.equals("OOO")){
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons(){
        switch (match) {
            case "012":
                buttons[0][0].setBackground(new Color (255,0,0));
                buttons[0][1].setBackground(new Color (255,0,0));
                buttons[0][2].setBackground(new Color (255,0,0));
                break;
            case "345":
                buttons[1][0].setBackground(new Color (255,0,0));
                buttons[1][1].setBackground(new Color (255,0,0));
                buttons[1][2].setBackground(new Color (255,0,0));
                break;
            case "678":
                buttons[2][0].setBackground(new Color (255,0,0));
                buttons[2][1].setBackground(new Color (255,0,0));
                buttons[2][2].setBackground(new Color (255,0,0));
                break;
            case "036":
                buttons[0][0].setBackground(new Color (255,0,0));
                buttons[1][0].setBackground(new Color (255,0,0));
                buttons[2][0].setBackground(new Color (255,0,0));
                break;
            case "147":
                buttons[0][1].setBackground(new Color (255,0,0));
                buttons[1][1].setBackground(new Color (255,0,0));
                buttons[2][1].setBackground(new Color (255,0,0));
                break;
            case "258":
                buttons[0][2].setBackground(new Color (255,0,0));
                buttons[1][2].setBackground(new Color (255,0,0));
                buttons[2][2].setBackground(new Color (255,0,0));
                break;
            case "048":
                buttons[0][0].setBackground(new Color (255,0,0));
                buttons[1][1].setBackground(new Color (255,0,0));
                buttons[2][2].setBackground(new Color (255,0,0));
                break;
            case "246":
                buttons[0][2].setBackground(new Color (255,0,0));
                buttons[1][1].setBackground(new Color (255,0,0));
                buttons[2][0].setBackground(new Color (255,0,0));
                break;
            
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        Window11 boardGame = new Window11();
        boardGame.setBounds(0, 0, 345, 400);
        boardGame.setVisible(true);
        boardGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardGame.setResizable(false);
        boardGame.setLocationRelativeTo(null);
        boardGame.setTitle("TicTacToe");
        boardGame.getContentPane().setBackground(new Color(20,20,20));
    }

}
