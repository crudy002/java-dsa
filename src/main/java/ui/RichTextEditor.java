package main.java.ui;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RichTextEditor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rich Text Editor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTextPane textPane = new JTextPane();
            JScrollPane scrollPane = new JScrollPane(textPane);
            frame.add(scrollPane, BorderLayout.CENTER);

            JPanel panel = new JPanel();
            JButton boldButton = new JButton("Bold");
            boldButton.addActionListener(e -> setBold(textPane));
            panel.add(boldButton);

            JButton italicButton = new JButton("Italic");
            italicButton.addActionListener(e -> setItalic(textPane));
            panel.add(italicButton);

            JButton codeButton = new JButton("Code");
            codeButton.addActionListener(e -> setCode(textPane));
            panel.add(codeButton);

            JButton regularButton = new JButton("Regular");
            regularButton.addActionListener(e -> setRegular(textPane));
            panel.add(regularButton);

            JButton exportButton = new JButton("Export");
            exportButton.addActionListener(e -> exportText(textPane));
            panel.add(exportButton);

            frame.add(panel, BorderLayout.NORTH);
            
            setRegular(textPane);

            frame.setVisible(true);
        });
    }

    public static void setBold(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start != end) {
            Style style = textPane.addStyle("Bold", null);
            StyleConstants.setBold(style, true);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }

    public static void setItalic(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start != end) {
            Style style = textPane.addStyle("Italic", null);
            StyleConstants.setItalic(style, true);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }

    public static void setCode(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start != end) {
            Style style = textPane.addStyle("Code", null);
            StyleConstants.setFontFamily(style, "Monospaced");
            StyleConstants.setForeground(style, Color.BLUE);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }

    public static void setRegular(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start != end) {
            Style defaultStyle = textPane.addStyle("Default", null);
            StyleConstants.setFontFamily(defaultStyle, "Serif");
            StyleConstants.setBold(defaultStyle, false);
            StyleConstants.setItalic(defaultStyle, false);
            StyleConstants.setForeground(defaultStyle, Color.BLACK);
            doc.setCharacterAttributes(start, end - start, defaultStyle, true);
        }
    }

    public static void exportText(JTextPane textPane) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                // Export the content as HTML
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer, textPane.getDocument(), 0, textPane.getDocument().getLength());
                JOptionPane.showMessageDialog(null, "Text exported successfully!");
            } catch (IOException | BadLocationException ex) {
                JOptionPane.showMessageDialog(null, "Error exporting text: " + ex.getMessage());
            }
        }
    }
}


