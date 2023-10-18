//CONECTA 4
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Connect4 extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;
    public Color fontColorButton = new Color(255,255,255);
    public Color fontColorButtonWin = new Color(255,0,0);
    public String match;
    private JMenuBar menuBar;
    private JMenu menu, menuInfo;
    private JMenuItem menuItemOut, menuItemRestart, menuItemAbout;


    public Connect4(){
        setLayout(null);
        
        Color fontColorButton = new Color(255,255,255);
        buttons = new JButton[7][6];
        currentPlayer = '1';

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 0, 0));

        setJMenuBar(menuBar);

        menu = new JMenu("Opciones");
        menu.setFont(new Font("Andale mono", 1, 14));
        menu.setForeground(new Color(255,255,255));
        menuBar.add(menu);

        menuInfo = new JMenu("Informacion");
        menuInfo.setFont(new Font("Andale mono", 1, 14));
        menuInfo.setForeground(new Color(255,255,255));
        menuBar.add(menuInfo);

        menuItemAbout = new JMenuItem("Acerca de ...");
        menuItemAbout.setFont(new Font("Andele mono", 1, 14));
        menuItemAbout.addActionListener(this);
        menuInfo.add(menuItemAbout);

        menuItemRestart = new JMenuItem("Reiniciar");
        menuItemRestart.setFont(new Font("Andele mono", 1, 14));
        menuItemRestart.addActionListener(this);
        menu.add(menuItemRestart);


        menuItemOut = new JMenuItem( "Salir");
        menuItemOut.setFont(new Font("Andale mono", 1, 14));
        menuItemOut.addActionListener(this);
        menu.add(menuItemOut);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("<html>Turno del jugador <font color ='red'>1</font></html>");

        statusLabel.setBounds(200, 5, 315, 20);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setForeground(fontColorButton);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                    buttons[i][j] = new JButton("");
                    buttons[i][j].setBounds((i*105)+10,(j*105)+50,100,100);
                    buttons[i][j].setFont(new Font("Arial",Font.BOLD,48));
                    buttons[i][j].setBackground(new Color(50,50,50));
                    buttons[i][j].addActionListener(this);;
                    add(buttons[i][j]);
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < 6; j++) {
                buttons[i][j].setEnabled(false);
            }
        }

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == menuItemAbout){
            JOptionPane.showMessageDialog(null, "Elaborado por Paulina Alvarez y Vicente Valenzuela");
            return;
        }
        if(e.getSource() == menuItemOut){
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea salir de la aplicacion?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            return;
        }
        if(e.getSource() == menuItemRestart){
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    buttons[i][j].setText("");
                    buttons[i][0].setEnabled(true);
                    buttons[i][j].setForeground(fontColorButton);
                    buttons[i][j].setBackground(new Color(50,50,50));
                }
            }
            if (currentPlayer == '1')
            {
            statusLabel.setText("<html>Turno del jugador <font color ='red'>1</font></html>");
            }
            else
            {
            statusLabel.setText("<html>Turno del jugador <font color ='blue'>2</font></html>");
            }
            return;
        }


        JButton buttonClicked = (JButton) e.getSource();

        if(!buttonClicked.getText().equals("")){
            return;
        }

        System.out.println(buttonClicked.getY()/105);
        System.out.println(buttonClicked.getX()/105);

        int row = buttonClicked.getY()/105;
        int column = buttonClicked.getX()/105;
        
        int MAXROW = 5;
        int counter = 1;
            for (int j = 0; j < 6; j++) {
                if (!buttons[column][j].getText().equals("")){
                    MAXROW = j-counter;
                    counter++;
                }
            }
        if (currentPlayer=='1'){
        buttons[column][row+MAXROW].setForeground(Color.RED);
        buttons[column][row+MAXROW].setUI(new MetalButtonUI(){
            protected Color getDisabledTextColor() {
                return Color.RED;
            }
        });        
        buttons[column][row+MAXROW].setText("O");
        }
        else {
        buttons[column][row+MAXROW].setForeground(Color.BLUE);
        buttons[column][row+MAXROW].setText("O");
        buttons[column][row+MAXROW].setUI(new MetalButtonUI(){
            protected Color getDisabledTextColor() {
                return Color.BLUE;
            }
        });    
        }

        if (checkWin()){
            if (currentPlayer == '1')
            {
            statusLabel.setText("<html>Jugador <font color ='red'>1</font> gana</html>");
            }
            else
            {
            statusLabel.setText("<html>Jugador <font color ='blue'>2</font> gana</html>");
            }
            disableButtons();
        }else if (isBoardFull()){
            statusLabel.setText("¡Empate!");
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    buttons[i][j].setBackground(new Color(255,255,255));
                }
            }
        }else {
            currentPlayer = (currentPlayer == '1') ? '2' : '1';
            if (currentPlayer == '1')
            {
            statusLabel.setText("<html>Turno del jugador <font color ='red'>1</font></html>");
            }
            else
            {
            statusLabel.setText("<html>Turno del jugador <font color ='blue'>2</font></html>");
            }
        }
    }

    private boolean checkWin(){

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (buttons[i][j].getForeground()==Color.RED || buttons[i][j].getForeground()==Color.BLUE){
                    if (i+3 < 7){    
                    if (buttons[i][j].getForeground()==buttons[i+1][j].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+2][j].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+3][j].getForeground()){
                            buttons[i][j].setBackground(buttons[i][j].getForeground());
                            buttons[i+1][j].setBackground(buttons[i][j].getForeground());
                            buttons[i+2][j].setBackground(buttons[i][j].getForeground());
                            buttons[i+3][j].setBackground(buttons[i][j].getForeground());
                            return true;
                        }       
                    }
                    if (j+3 < 6){    
                    if (buttons[i][j].getForeground()==buttons[i][j+1].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i][j+2].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i][j+3].getForeground()){
                            buttons[i][j].setBackground(buttons[i][j].getForeground());
                            buttons[i][j+1].setBackground(buttons[i][j].getForeground());
                            buttons[i][j+2].setBackground(buttons[i][j].getForeground());
                            buttons[i][j+3].setBackground(buttons[i][j].getForeground());
                            return true;
                        }       
                    }
                    if (i+3 < 7 && j+3 < 6){
                    if (buttons[i][j].getForeground()==buttons[i+1][j+1].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+2][j+2].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+3][j+3].getForeground()){
                            buttons[i][j].setBackground(buttons[i][j].getForeground());
                            buttons[i+1][j+1].setBackground(buttons[i][j].getForeground());
                            buttons[i+2][j+2].setBackground(buttons[i][j].getForeground());
                            buttons[i+3][j+3].setBackground(buttons[i][j].getForeground());
                            return true;
                        }       
                    }
                    if (i+3 < 7 && j-3 >= 0){
                    if (buttons[i][j].getForeground()==buttons[i+1][j-1].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+2][j-2].getForeground() &&
                        buttons[i][j].getForeground()==buttons[i+3][j-3].getForeground()){
                            buttons[i][j].setBackground(buttons[i][j].getForeground());
                            buttons[i+1][j-1].setBackground(buttons[i][j].getForeground());
                            buttons[i+2][j-2].setBackground(buttons[i][j].getForeground());
                            buttons[i+3][j-3].setBackground(buttons[i][j].getForeground());
                            return true;
                        }       
                    }                       
                }
            }
        }

        return false;
    }

    private boolean isBoardFull(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (buttons[i][j].getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons(){

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        Connect4 boardGame = new Connect4();
        boardGame.setBounds(0, 0, 770, 800);
        boardGame.setVisible(true);
        boardGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardGame.setResizable(false);
        boardGame.setLocationRelativeTo(null);
        boardGame.setTitle("Connect 4");
        boardGame.getContentPane().setBackground(new Color(20,20,20));
    }

}