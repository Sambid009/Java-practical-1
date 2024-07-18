package pr1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NumberFinder {
    JFrame frame;
    JTextField firstNumberField, secondNumberField;
    JButton findEvenButton, findPrimeButton;
    JTextArea resultArea;
    JLabel firstNumberLabel, secondNumberLabel;

    public void setUpGUI() {
        frame = new JFrame("Number Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Setting up components
        firstNumberLabel = new JLabel("First Number:");
        firstNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        secondNumberLabel = new JLabel("Second Number:");
        secondNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));

        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);

        findEvenButton = new JButton("Find Even");
        findPrimeButton = new JButton("Find Prime");

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Setting up the layout
        frame.setLayout(new FlowLayout());

        // Adding components to frame
        frame.add(firstNumberLabel);
        frame.add(firstNumberField);
        frame.add(secondNumberLabel);
        frame.add(secondNumberField);
        frame.add(findEvenButton);
        frame.add(findPrimeButton);
        frame.add(new JScrollPane(resultArea));

        // Adding action listeners
        findEvenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findEvenNumbers();
            }
        });

        findPrimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findPrimeNumbers();
            }
        });

        frame.setVisible(true);
    }

    void findEvenNumbers() {
        int firstNumber = Integer.parseInt(firstNumberField.getText());
        int secondNumber = Integer.parseInt(secondNumberField.getText());

        StringBuilder result = new StringBuilder();
        for (int i = firstNumber; i <= secondNumber; i++) {
            if (i % 2 == 0) {
                result.append(i).append(" ");
            }
        }
        resultArea.setText("Even Numbers: " + result.toString());
    }

    void findPrimeNumbers() {
        int firstNumber = Integer.parseInt(firstNumberField.getText());
        int secondNumber = Integer.parseInt(secondNumberField.getText());

        StringBuilder result = new StringBuilder();
        for (int i = firstNumber; i <= secondNumber; i++) {
            if (isPrime(i)) {
                result.append(i).append(" ");
            }
        }
        resultArea.setText("Prime Numbers: " + result.toString());
    }

    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberFinder finder = new NumberFinder();
        finder.setUpGUI();
    }
}
