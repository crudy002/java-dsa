package main.java.ui;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.event.ActionEvent;

public class ThemeToggle {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("Toggle Theme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Toggle button
        JButton toggleButton = new JButton("Toggle Dark Mode");
        toggleButton.addActionListener(ThemeToggle::toggleTheme);
        frame.add(toggleButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void toggleTheme(ActionEvent e) {
        try {
            if (UIManager.getLookAndFeel() instanceof FlatLightLaf) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
            // Update UI components to reflect the change
            SwingUtilities.updateComponentTreeUI(((JComponent) e.getSource()).getTopLevelAncestor());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

