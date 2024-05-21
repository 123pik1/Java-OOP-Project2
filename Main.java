import java.awt.Dimension;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        // Create a new JFrame
        JFrame frame = new JFrame();

        // Create a large panel that won't fit into the layout
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));

        // Create a JScrollPane and add the panel to it
        JScrollPane scrollPane = new JScrollPane(panel);

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane);

        // Set the JFrame size, close operation and make it visible
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}