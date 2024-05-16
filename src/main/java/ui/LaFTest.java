package main.java.ui;

import javax.swing.*;
import java.awt.event.*;

public class LaFTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createMainGUI(); // Launch the main GUI
        });
    }

    private static void createMainGUI() {
        // Setting initial Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("Main Application");
        JButton launchButton = new JButton("Launch Child Window");
        launchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchChildGUI();
            }
        });

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add(launchButton);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private static void launchChildGUI() {
        // Temporarily set a different Look and Feel for the new window
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame childFrame = new JFrame("Child Window");
        childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        childFrame.getContentPane().add(new JLabel("I am a different look and feel!"));
        childFrame.pack();
        childFrame.setLocationRelativeTo(null);
        childFrame.setVisible(true);

        // Reset to the original Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

