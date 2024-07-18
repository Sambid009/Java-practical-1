package pr1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SumDifferenceControls {
    JTextField num1Field;
    JTextField num2Field;
    JTextField resultField;
    JLabel statusLabel;
    JFrame frame;

    public void setUpGUI() {
        frame = new JFrame("Sum and Difference Calculator");
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        statusLabel = new JLabel("Status");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Number 1:"));
        frame.add(num1Field);
        frame.add(new JLabel("Number 2:"));
        frame.add(num2Field);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        frame.add(statusLabel);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addEventHandlers();
    }

    private void addEventHandlers() {
        // Mouse Listener using Adapter
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        };

        num1Field.addMouseListener(mouseAdapter);
        num2Field.addMouseListener(mouseAdapter);
        resultField.addMouseListener(mouseAdapter);

         
        resultField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                statusLabel.setText("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusLabel.setText("Mouse Exited");
            }
        });
    }

    private void calculateSum() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int sum = num1 + num2;
            resultField.setText(String.valueOf(sum));
            statusLabel.setText("Sum calculated");
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
            statusLabel.setText("Invalid input");
        }
    }

    private void calculateDifference() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int difference = num1 - num2;
            resultField.setText(String.valueOf(difference));
            statusLabel.setText("Difference calculated");
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
            statusLabel.setText("Invalid input");
        }
    }
}

public class SumDifferenceApp {
    public static void main(String[] args) {
        SumDifferenceControls controls = new SumDifferenceControls();
        controls.setUpGUI();
    }
}
