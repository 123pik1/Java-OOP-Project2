import java.awt.Dimension;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        // Create a JFrame
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a Box
        Box box = Box.createHorizontalBox();

        // Create a JButton
        JButton button1 = new JButton("Button 1");
        box.add(button1);

        // Add a rigid area (i.e., invisible component) to the Box
        box.add(Box.createRigidArea(new Dimension(100, 0)));

        // Create another JButton
        JButton button2 = new JButton("Button 2");
        box.add(button2);

        // Add the Box to the JFrame
        jFrame.add(box);

        // Make the JFrame visible
        jFrame.setVisible(true);
    }
}