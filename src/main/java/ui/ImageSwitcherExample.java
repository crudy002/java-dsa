package main.java.ui;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageSwitcherExample extends JFrame {
    private JLabel imageLabel;
    private JComboBox<String> imageSelector;

    public ImageSwitcherExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Switcher Example");
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create a panel to add to the frame
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Create and set up the image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Create a dropdown (JComboBox) for image selection
        String[] imageOptions = {"ArrayView2", "C_language_linked_list_adding_a_link_step_1"};
        imageSelector = new JComboBox<>(imageOptions);
        panel.add(imageSelector, BorderLayout.NORTH);

        // Add ActionListener to the JComboBox
        imageSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedImage = (String) imageSelector.getSelectedItem();
                updateImage(selectedImage);
            }
        });

        // Load the initial image
        updateImage("ArrayView2");
    }

    private void updateImage(String imageName) {
        String imagePath = "/resources/" + imageName.toLowerCase().replace(" ", "") + ".png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));

        // Resize the image icon if necessary
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Adjust the size as needed
        imageIcon = new ImageIcon(newimg);

        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageSwitcherExample().setVisible(true));
    }
}


