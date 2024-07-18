package pr1;

import javax.swing.*;
import java.awt.*;

class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set anti-aliasing for better rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw Rectangle
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 50);

        // Draw Circle (Oval)
        g2d.setColor(Color.BLUE);
        g2d.fillOval(200, 50, 50, 50);

        // Draw Arc
        g2d.setColor(Color.GREEN);
        g2d.fillArc(300, 50, 50, 50, 0, 180);

        // Draw Polygon
        g2d.setColor(Color.MAGENTA);
        int[] xPoints = {400, 450, 425};
        int[] yPoints = {50, 50, 100};
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Draw Text with Font Properties
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("Hello, 2D Graphics!", 50, 200);

        // Draw Line
        g2d.setColor(Color.ORANGE);
        g2d.drawLine(50, 250, 200, 300);
    }
}

public class GraphicsDemo {
    JFrame frame;

    public void setUpGUI() {
        frame = new JFrame("2D Graphics and Font Properties Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Add drawing panel to frame
        frame.add(new DrawingPanel());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GraphicsDemo demo = new GraphicsDemo();
        demo.setUpGUI();
    }
}
