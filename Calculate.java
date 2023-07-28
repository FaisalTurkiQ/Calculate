package Calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculate extends JFrame implements ActionListener {
    Container container;
    TextField textField;
    JPanel panel;
    JButton numberButtons[],functionButtons[],addButton,subButton,mulButton,divButton,equButton,clrButton;
    int firstNumber,secondNumber,result;
    char operator;

    public Calculate() {
        container = getContentPane();

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(4, 4));

        textField = new TextField();
        textField.setPreferredSize(new Dimension(200,50));

        container.add(textField, "North");
        container.add(panel);

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(""+i);
            numberButtons[i].addActionListener(this);
            //numberButtons[i].setBackground(Color.orange);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");

        functionButtons =new JButton[6];
        functionButtons [0] = addButton;
        functionButtons [1] = subButton;
        functionButtons [2] = mulButton;
        functionButtons [3] = clrButton;
        functionButtons [4] = equButton;
        functionButtons [5] = divButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
        }

        panel.add(numberButtons[0]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(addButton);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(subButton);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(mulButton);
        panel.add(numberButtons[9]);
        panel.add(clrButton);
        panel.add(equButton);
        panel.add(divButton);



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My Calculator");
        setLocation(500, 500);
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        for (int i=0;i<10;i++) {
            if (ae.getSource().equals(numberButtons[i])) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (ae.getSource().equals(addButton)) {
            firstNumber = Integer.parseInt(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (ae.getSource().equals(subButton)) {
            firstNumber = Integer.parseInt(textField.getText());
            operator ='-';
            textField.setText("");
        }

        if (ae.getSource().equals(mulButton)) {
            firstNumber = Integer.parseInt(textField.getText());
            operator = '*';
            textField.setText("");

        }

        if (ae.getSource().equals(divButton)) {
            firstNumber = Integer.parseInt(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (ae.getSource().equals(equButton)){
            secondNumber = Integer.parseInt(textField.getText());

            switch (operator){
                case '+':
                    result = firstNumber+secondNumber;
                    break;
                case '-':
                    result = firstNumber-secondNumber;
                    break;
                case '*':
                    result = firstNumber*secondNumber;
                    break;
                case '/':
                    result = firstNumber/secondNumber;
                    break;
            }
            textField.setText(""+result);
            firstNumber = result;
        }
        if (ae.getSource().equals(clrButton)) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        Calculate obj = new Calculate();
    }
}