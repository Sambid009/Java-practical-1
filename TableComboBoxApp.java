package pr1;

import javax.swing.*;
import java.awt.*;

class TableComboBoxControls {
    JTable table;
    JComboBox<String> comboBox;
    JScrollPane scrollPane;
    JFrame frame;

    public void setUpGUI() {
        frame = new JFrame("JTable and JComboBox Example");

        // Create a JTable with sample data
        String[][] tableData = {
            {"1", "Sambid", "Dahal"},
            {"2", "Jane", "Smith"},
            {"3", "Jake", "McCarthy"}
        };
        String[] columnNames = {"ID", "First Name", "Last Name"};
        table = new JTable(tableData, columnNames);
        scrollPane = new JScrollPane(table);

        // Create a JComboBox with sample data
        String[] comboBoxData = {"Item 1", "Item 2", "Item 3"};
        comboBox = new JComboBox<>(comboBoxData);

        // Set up frame layout and add components
        frame.setLayout(new FlowLayout());
        frame.add(scrollPane);
        frame.add(comboBox);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

public class TableComboBoxApp {
    public static void main(String[] args) {
        TableComboBoxControls controls = new TableComboBoxControls();
        controls.setUpGUI();
    }
}
