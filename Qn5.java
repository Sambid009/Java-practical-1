 
package pr1;
 
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LayoutManagerExample {
    JFrame frame;
    JPanel cardPanel;
    CardLayout cardLayout;

    public void setUpGUI() {
        frame = new JFrame("Layout Manager Example");

        // Set up a panel for each layout manager
        JPanel nullPanel = createNullLayoutPanel();
        JPanel flowPanel = createFlowLayoutPanel();
        JPanel gridPanel = createGridLayoutPanel();
        JPanel borderPanel = createBorderLayoutPanel();
        JPanel cardPanel = createCardLayoutPanel();

        // CardLayout panel to switch between different layout panels
        cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        this.cardPanel.add(nullPanel, "Null Layout");
        this.cardPanel.add(flowPanel, "Flow Layout");
        this.cardPanel.add(gridPanel, "Grid Layout");
        this.cardPanel.add(borderPanel, "Border Layout");
        this.cardPanel.add(cardPanel, "Card Layout");

        // ComboBox to select the layout
        String[] layoutOptions = {"Null Layout", "Flow Layout", "Grid Layout", "Border Layout", "Card Layout"};
        JComboBox<String> layoutSelector = new JComboBox<>(layoutOptions);
        layoutSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLayout = (String) layoutSelector.getSelectedItem();
                cardLayout.show(LayoutManagerExample.this.cardPanel, selectedLayout);
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(layoutSelector, BorderLayout.NORTH);
        frame.add(this.cardPanel, BorderLayout.CENTER);

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel createNullLayoutPanel() {
        JPanel panel = new JPanel(null);
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        button1.setBounds(50, 50, 100, 30);
        button2.setBounds(200, 100, 100, 30);
        panel.add(button1);
        panel.add(button2);
        return panel;
    }

    private JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        return panel;
    }

    private JPanel createGridLayoutPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));
        return panel;
    }

    private JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("East"), BorderLayout.EAST);
        panel.add(new JButton("West"), BorderLayout.WEST);
        panel.add(new JButton("Center"), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCardLayoutPanel() {
        JPanel panel = new JPanel(new CardLayout());
        panel.add(new JLabel("Card 1"), "Card 1");
        panel.add(new JLabel("Card 2"), "Card 2");
        panel.add(new JLabel("Card 3"), "Card 3");

        CardLayout cardLayout = (CardLayout) panel.getLayout();
        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> cardLayout.next(panel));

        JPanel cardContainer = new JPanel(new BorderLayout());
        cardContainer.add(panel, BorderLayout.CENTER);
        cardContainer.add(nextButton, BorderLayout.SOUTH);

        return cardContainer;
    }
}

public class Qn5 {
    public static void main(String[] args) {
        LayoutManagerExample example = new LayoutManagerExample();
        example.setUpGUI();
    }
}