package pr1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EventControls {
    JButton actionButton;
    JCheckBox itemCheckBox;
    JList<String> listBox;
    JTextField keyTextField;
    JLabel statusLabel;
    JFrame frame;

    public void setUpGUI() {
        frame = new JFrame("Event Handling Example");
        actionButton = new JButton("Click Me");
        itemCheckBox = new JCheckBox("Check Me");
        String[] listData = {"Item 1", "Item 2", "Item 3"};
        listBox = new JList<>(listData);
        keyTextField = new JTextField(10);
        statusLabel = new JLabel("Status");

        frame.setLayout(new FlowLayout());
        frame.add(actionButton);
        frame.add(itemCheckBox);
        frame.add(new JScrollPane(listBox));
        frame.add(keyTextField);
        frame.add(statusLabel);
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addEventHandlers();
    }

    private void addEventHandlers() {
        // Action Event
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Action Button Clicked");
            }
        });

        // Item Event
        itemCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    statusLabel.setText("Item Checked");
                } else {
                    statusLabel.setText("Item Unchecked");
                }
            }
        });

      
        listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listBox.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                statusLabel.setText("List Selected: " + listBox.getSelectedValue());
            }
        });

    
        keyTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                statusLabel.setText("Key Typed: " + e.getKeyChar());
            }
        });

       
        keyTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusLabel.setText("Mouse Clicked: " + e.getX() + ", " + e.getY());
            }
        });

        // Mouse Event using MouseListener (Delegation Method)
        keyTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handled by Adapter Method
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
}

public class Question1 {
    public static void main(String[] args) {
        EventControls controls = new EventControls();
        controls.setUpGUI();
    }
}
