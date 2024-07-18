

package pr1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonControls {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JTextField textField;
    JFrame frame;

    public void setUpGUI() {
        frame = new JFrame("Button Click Example");
        button1 = new JButton("Button 1");
        button1.setBackground(Color.RED);
        button2 = new JButton("Button 2");
        button2.setBackground(Color.BLUE);
        button3 = new JButton("Button 3");
        button3.setBackground(Color.YELLOW);
        button4 = new JButton("Button 4");
        button4.setBackground(Color.GRAY);
        textField = new JTextField(20);
        textField.setEditable(false);

        frame.setLayout(new FlowLayout());
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(textField);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addEventHandlers();
    }

    private void addEventHandlers() {
        // Action Listeners for buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("First button is clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Second button is clicked");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Third button is clicked");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Fourth button is clicked");
            }
        });
    }
}

public class ButtonClickApp {
    public static void main(String[] args) {
        ButtonControls controls = new ButtonControls();
        controls.setUpGUI();
    }
}
