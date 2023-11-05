import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Window10 extends JFrame implements ActionListener{
    private JTextField textFieldScreen;
    private JButton buttonAC, buttonDeleteLast;
    private JButton buttonAdd, buttonSubstract, buttonMultiply, 
                    buttonDivision,buttonPoint,buttonResult,
                    buttonMod,buttonPower,buttonPi,buttonNegative;
    private JButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private JMenuBar menuBar;
    private JMenu menu,colorMenu;
    private JMenuItem menuItemOut,redTheme,blueTheme,blackTheme,whiteTheme;    
    
    String text = "";

    public Window10(){
        setLayout(null);

        Font fontTextField = new Font("Bahnschrift Condensed",1,20);
        Font fontButtons = new Font("Arial",1,20);
        Color fontColorTextField = new Color (255,255,255);
        Color colorButtons = new Color(160,221,249);

        setLayout(null);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("Options");
        menuBar.add(menu);

        colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);
        
        menuItemOut = new JMenuItem("Salir");
        menuItemOut.addActionListener(this);
        menu.add(menuItemOut);

        redTheme = new JMenuItem("Red");
        redTheme.addActionListener(this);
        colorMenu.add(redTheme);

        blueTheme = new JMenuItem("Blue");
        blueTheme.addActionListener(this);
        colorMenu.add(blueTheme);

        blackTheme = new JMenuItem("Black");
        blackTheme.addActionListener(this);
        colorMenu.add(blackTheme);

        whiteTheme = new JMenuItem("White");
        whiteTheme.addActionListener(this);
        colorMenu.add(whiteTheme);
        
        textFieldScreen = new JTextField();
        textFieldScreen.setBounds(5,5,360,50);
        textFieldScreen.setFont(fontTextField);
        textFieldScreen.setForeground(fontColorTextField);
        textFieldScreen.setBackground(new Color(18, 118, 168));
        textFieldScreen.setHorizontalAlignment(4);
        textFieldScreen.setEditable(false);
        add(textFieldScreen);

        buttonAC = new JButton("AC");
        buttonAC.setFont(new Font("Arial", 1, 16));
        buttonAC.setBounds(10, 70, 60, 50);
        buttonAC.setBackground(new Color(255, 0, 0));
        buttonAC.setForeground(fontColorTextField);
        add(buttonAC);
        buttonAC.addActionListener(this);

        buttonDeleteLast = new JButton("<x");
        buttonDeleteLast.setFont(new Font("Arial", 1, 16));
        buttonDeleteLast.setBackground(colorButtons);
        buttonDeleteLast.setBounds(80, 70, 60, 50);
        buttonDeleteLast.setForeground(fontColorTextField);
        add(buttonDeleteLast);
        buttonDeleteLast.addActionListener(this);

        button9 = new JButton("9");
        button9.setFont(fontButtons);
        button9.setBackground(colorButtons);
        button9.setBounds(150, 140, 60, 50);
        button9.setForeground(fontColorTextField);
        add(button9);
        button9.addActionListener(this);

        button8 = new JButton("8");
        button8.setFont(fontButtons);
        button8.setBackground(colorButtons);
        button8.setBounds(80, 140, 60, 50);
        button8.setForeground(fontColorTextField);
        add(button8);
        button8.addActionListener(this);

        button7 = new JButton("7");
        button7.setFont(fontButtons);
        button7.setBackground(colorButtons);
        button7.setBounds(10, 140, 60, 50);
        button7.setForeground(fontColorTextField);
        add(button7);
        button7.addActionListener(this);

        button6 = new JButton("6");
        button6.setFont(fontButtons);
        button6.setBackground(colorButtons);
        button6.setBounds(150,210, 60, 50);
        button6.setForeground(fontColorTextField);
        add(button6);
        button6.addActionListener(this);

        button5 = new JButton("5");
        button5.setFont(fontButtons);
        button5.setBackground(colorButtons);
        button5.setBounds(80, 210, 60, 50);
        button5.setForeground(fontColorTextField);
        add(button5);
        button5.addActionListener(this);

        button4 = new JButton("4");
        button4.setFont(fontButtons);
        button4.setBackground(colorButtons);
        button4.setBounds(10, 210, 60, 50);
        button4.setForeground(fontColorTextField);
        add(button4);
        button4.addActionListener(this);


        button3 = new JButton("3");
        button3.setFont(fontButtons);
        button3.setBackground(colorButtons);
        button3.setBounds(150,280, 60, 50);
        button3.setForeground(fontColorTextField);
        add(button3);
        button3.addActionListener(this);

        button2 = new JButton("2");
        button2.setFont(fontButtons);
        button2.setBackground(colorButtons);
        button2.setBounds(80, 280, 60, 50);
        button2.setForeground(fontColorTextField);
        add(button2);
        button2.addActionListener(this);

        button1 = new JButton("1");
        button1.setFont(fontButtons);
        button1.setBackground(colorButtons);
        button1.setBounds(10, 280, 60, 50);
        button1.setForeground(fontColorTextField);
        add(button1);
        button1.addActionListener(this);

        button0 = new JButton("0");
        button0.setFont(fontButtons);
        button0.setBackground(colorButtons);
        button0.setBounds(10, 350, 60, 50);
        button0.setForeground(fontColorTextField);
        add(button0);
        button0.addActionListener(this);

        buttonPoint = new JButton(".");
        buttonPoint.setFont(fontButtons);
        buttonPoint.setBackground(colorButtons);
        buttonPoint.setBounds(80, 350, 60, 50);
        buttonPoint.setForeground(fontColorTextField);
        add(buttonPoint);
        buttonPoint.addActionListener(this);

        buttonResult = new JButton("=");
        buttonResult.setFont(fontButtons);
        buttonResult.setBackground(colorButtons);
        buttonResult.setBounds(150, 350, 60, 50);
        buttonResult.setForeground(fontColorTextField);
        add(buttonResult);
        buttonResult.addActionListener(this);

        buttonMultiply = new JButton("x");
        buttonMultiply.setFont(fontButtons);
        buttonMultiply.setBackground(colorButtons);
        buttonMultiply.setBounds(220, 140, 60, 50);
        buttonMultiply.setForeground(fontColorTextField);
        add(buttonMultiply);
        buttonMultiply.addActionListener(this);

        buttonSubstract = new JButton("-");
        buttonSubstract.setFont(fontButtons);
        buttonSubstract.setBackground(colorButtons);
        buttonSubstract.setBounds(220, 210, 60, 50);
        buttonSubstract.setForeground(fontColorTextField);
        add(buttonSubstract);
        buttonSubstract.addActionListener(this);
        
        buttonAdd = new JButton("+");
        buttonAdd.setFont(fontButtons);
        buttonAdd.setBackground(colorButtons);
        buttonAdd.setBounds(220, 280, 60, 120);
        buttonAdd.setForeground(fontColorTextField);
        add(buttonAdd);
        buttonAdd.addActionListener(this);

        buttonDivision = new JButton("/");
        buttonDivision.setFont(fontButtons);
        buttonDivision.setBackground(colorButtons);
        buttonDivision.setBounds(220, 70, 60, 50);
        buttonDivision.setForeground(fontColorTextField);
        add(buttonDivision);
        buttonDivision.addActionListener(this);

        buttonPower = new JButton("^");
        buttonPower.setFont(fontButtons);
        buttonPower.setBackground(colorButtons);
        buttonPower.setBounds(290, 140, 60, 50);
        buttonPower.setForeground(fontColorTextField);
        add(buttonPower);
        buttonPower.addActionListener(this);

        buttonMod = new JButton("%");
        buttonMod.setFont(fontButtons);
        buttonMod.setBackground(colorButtons);
        buttonMod.setBounds(290, 210, 60, 50);
        buttonMod.setForeground(fontColorTextField);
        add(buttonMod);
        buttonMod.addActionListener(this);

        buttonPi = new JButton("\u03C0");
        buttonPi.setFont(fontButtons);
        buttonPi.setBackground(colorButtons);
        buttonPi.setBounds(290, 280, 60, 50);
        buttonPi.setForeground(fontColorTextField);
        add(buttonPi);
        buttonPi.addActionListener(this);

        buttonNegative = new JButton("-1");
        buttonNegative.setFont(fontButtons);
        buttonNegative.setBackground(colorButtons);
        buttonNegative.setBounds(150, 70, 60, 50);
        buttonNegative.setForeground(fontColorTextField);
        add(buttonNegative);
        buttonNegative.addActionListener(this);
    }    
        



    public void actionPerformed(ActionEvent e){
        if (e.getSource() == redTheme) {
            getContentPane().setBackground(new Color(200,100,100));
        }
        if (e.getSource() == blueTheme) {
            getContentPane().setBackground(new Color(100,100,200));
        }
        if (e.getSource() == blackTheme) {
            getContentPane().setBackground(new Color(20,20,20));
        }
        if (e.getSource() == whiteTheme) {
            getContentPane().setBackground(new Color(220,220,220,1));
        }
        if (e.getSource() == buttonAC) {
            textFieldScreen.setText("");
        }
        if(e.getSource() == buttonDeleteLast){
            int lastToDelete = textFieldScreen.getText().length();
            textFieldScreen.setText(textFieldScreen.getText().substring(0,lastToDelete-1));
        }

        if (e.getSource() == button1) {
            textFieldScreen.setText(textFieldScreen.getText() + "1");
        }

        if (e.getSource() == button2) {
            textFieldScreen.setText(textFieldScreen.getText() + "2");
        }

        if (e.getSource() == button3) {
            textFieldScreen.setText(textFieldScreen.getText() + "3");
        }

        if (e.getSource() == button4) {
            textFieldScreen.setText(textFieldScreen.getText() + "4");
        }

        if (e.getSource() == button5) {
            textFieldScreen.setText(textFieldScreen.getText() + "5");
        }

        if (e.getSource() == button6) {
            textFieldScreen.setText(textFieldScreen.getText() + "6");
        }

        if (e.getSource() == button7) {
            textFieldScreen.setText(textFieldScreen.getText() + "7");
        }

        if (e.getSource() == button8) {
            textFieldScreen.setText(textFieldScreen.getText() + "8");
        }

        if (e.getSource() == button9) {
            textFieldScreen.setText(textFieldScreen.getText() + "9");
        }

        if (e.getSource() == button0) {
            textFieldScreen.setText(textFieldScreen.getText() + "0");
        }

        if (e.getSource() == buttonAdd) {
            textFieldScreen.setText(textFieldScreen.getText() + "+");
        }

        if (e.getSource() == buttonSubstract) {
            textFieldScreen.setText(textFieldScreen.getText() + "-");
        }

        if (e.getSource() == buttonMultiply) {
            textFieldScreen.setText(textFieldScreen.getText() + "x");
        }

        if (e.getSource() == buttonDivision) {
            textFieldScreen.setText(textFieldScreen.getText() + "/");
        }

        if (e.getSource() == buttonMod) {
            textFieldScreen.setText(textFieldScreen.getText() + "%");
        }

        if (e.getSource() == buttonPower) {
            textFieldScreen.setText(textFieldScreen.getText() + "^");
        }

        if (e.getSource() == buttonPi) {
            textFieldScreen.setText(textFieldScreen.getText() + "3.1416");
        }

        if (e.getSource() == buttonPoint) {
            textFieldScreen.setText(textFieldScreen.getText() + ".");
        }

        if (e.getSource() == buttonNegative) {
            textFieldScreen.setText(String.valueOf(Float.parseFloat(textFieldScreen.getText())*-1));
        }

        if(e.getSource() == buttonResult){
            textFieldScreen.setText(Operations(textFieldScreen.getText()));
        }

        if(e.getSource()== menuItemOut){
            int response = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
        }
    }

    public static String Operations (String operations){
        String finalResult ="", operatorOption ="";
        float value1 = 0f, value2 = 0f;
        char operator;
        int operationSize = operations.length();
        for (int i = 0; i < operationSize; i++) {
            operator = operations.charAt(i);
            if ((operator == '+' || operator == '-' || operator == 'x' || operator == '/' ||
            operator =='%' || operator == '^') && i!=0)
            {       
                value1 = Float.parseFloat(operations.substring(0, i));
                value2 = Float.parseFloat(operations.substring(i+1, operationSize));
                operatorOption = operations.substring(i, i+1);
                break;
            }
        }
        switch (operatorOption) {
            case "+": {finalResult = Float.toString(value1+value2); break;}
            case "-": {finalResult = Float.toString(value1-value2); break;}
            case "x": {finalResult = Float.toString(value1*value2); break;}
            case "/": {finalResult = Float.toString(value1/value2); break;}
            case "^": {finalResult = Double.toString(Math.pow(value1, value2)); break;}
            case "%": {finalResult = Float.toString((value1*value2)/100); break;}
            default: finalResult = "error";
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Window10 basicCalculator = new Window10();
        basicCalculator.setBounds(0, 0, 375, 470);
        basicCalculator.setVisible(true);
        basicCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        basicCalculator.setResizable(false);
        basicCalculator.setLocationRelativeTo(null);
        basicCalculator.setTitle("First Window");
        basicCalculator.getContentPane().setBackground(new Color(220,220,220,1));
    }
}
