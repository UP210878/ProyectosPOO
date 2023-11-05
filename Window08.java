import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Window08 extends JFrame implements ActionListener{
    private JTextField textField1,textField2;
    private JLabel label1,label2,label3,labelBox;
    private JButton buttonAdd, buttonSubstract, buttonMultiply, buttonDivision,buttonCloseWindow;
    
    String texto = "";

    public Window08(){
        setLayout(null);

        label1 = new JLabel("Valor 1");
        label1.setBounds(50, 5, 100, 30);
        add(label1);

        label2 = new JLabel("Valor 2");
        label2.setBounds(50, 35, 100, 30);
        add(label2);

        label3 = new JLabel("Resultado");
        label3.setBounds(120, 80, 100, 30);
        add(label3);

        labelBox = new JLabel("");
        labelBox.setBounds(120, 100, 100, 30);
        add(labelBox);

        textField1 = new JTextField();
        textField1.setBounds(100, 5, 200, 30);
        add(textField1);
        

        textField2 = new JTextField();
        textField2.setBounds(100, 35, 200, 30);
        add(textField2);

        buttonAdd = new JButton("+");
        buttonAdd.setBounds(10, 80, 90, 30);
        add(buttonAdd);
        buttonAdd.addActionListener(this);

        buttonSubstract = new JButton("-");
        buttonSubstract.setBounds(10, 120, 90, 30);
        add(buttonSubstract);
        buttonSubstract.addActionListener(this);

        buttonDivision = new JButton("/");
        buttonDivision.setBounds(10, 160, 90, 30);
        add(buttonDivision);
        buttonDivision.addActionListener(this);

        
        buttonMultiply = new JButton("*");
        buttonMultiply.setBounds(10, 200, 90, 30);
        add(buttonMultiply);
        buttonMultiply.addActionListener(this);

        buttonCloseWindow = new JButton("Exit");
        buttonCloseWindow.setBounds(100, 260, 90, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);

    }    


    public void actionPerformed(ActionEvent e){
        int value1 = 0, value2 = 1, result = 0;

        if (e.getSource() == buttonCloseWindow){
            int response = JOptionPane.showConfirmDialog
            (this, "Desea salir de la aplicacion", 
            "Confirmar Salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }
        }

        if (e.getSource() ==buttonAdd){
            value1 = Integer.parseInt(textField1.getText());
            value2 = Integer.parseInt(textField2.getText());
            result = value1 + value2;
        }

        if (e.getSource() ==buttonSubstract){
            value1 = Integer.parseInt(textField1.getText());
            value2 = Integer.parseInt(textField2.getText());
            result = value1 - value2;
        }

        if (e.getSource() ==buttonDivision){
            value1 = Integer.parseInt(textField1.getText());
            value2 = Integer.parseInt(textField2.getText());
            result = value1 / value2;
        }
        
        if (e.getSource() ==buttonMultiply){
            value1 = Integer.parseInt(textField1.getText());
            value2 = Integer.parseInt(textField2.getText());
            result = value1 * value2;
        }

        labelBox.setText("->        " + result);
        result = 0;
    }

    public static void main(String[] args) {
        Window08 simpleCalculator = new Window08();
        simpleCalculator.setBounds(0, 0, 350, 400);
        simpleCalculator.setVisible(true);
        simpleCalculator.setResizable(false);
        simpleCalculator.setLocationRelativeTo(null);
        simpleCalculator.setTitle("Calculator Prototype");
        simpleCalculator.getContentPane().setBackground(new Color(200,200,200));
    }
}
