package main.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

class DataStructurePanel extends JPanel {
    private String type;
    private Object dataStructure;

    public DataStructurePanel() {
        this.setPreferredSize(new Dimension(400, 300)); // Adjust size as needed
    }

    public void setDataStructure(String type, Object dataStructure) {
        this.type = type;
        this.dataStructure = dataStructure;
        this.repaint(); // Trigger a repaint whenever the data structure changes
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dataStructure == null) return;

        switch (type) {
            case "Array":
                drawArray(g, (int[]) dataStructure);
                break;
            case "Linked List":
                drawLinkedList(g, (LinkedList<Integer>) dataStructure);
                break;
            // Add cases for other types...
        }
    }

    private void drawArray(Graphics g, int[] array) {
        if (array == null || array.length == 0) return; // Nothing to draw if the array is empty

        // Set color for array elements
        g.setColor(Color.BLUE);
        
        // Determine the size of each cell based on the panel size and array length
        int cellWidth = getWidth() / array.length;
        int cellHeight = 50; // Fixed height for each cell
        int xOffset = 10; // Starting x position offset
        int yOffset = 30; // Starting y position offset

        for (int i = 0; i < array.length; i++) {
            // Calculate the x position for each cell
            int x = xOffset + i * cellWidth;
            
            // Draw the cell for the current array element
            g.drawRect(x, yOffset, cellWidth - 5, cellHeight); // Subtract 5 to provide some padding between cells
            
            // Draw the array value centered in the cell
            String value = String.valueOf(array[i]);
            FontMetrics fm = g.getFontMetrics();
            int valueWidth = fm.stringWidth(value);
            int valueHeight = fm.getAscent();
            int valueX = x + (cellWidth - valueWidth) / 2;
            int valueY = yOffset + (cellHeight + valueHeight) / 2;
            g.drawString(value, valueX, valueY);
            
            // Optionally, draw the index above the cell
            g.drawString("Index " + i, x + (cellWidth - fm.stringWidth("Index " + i)) / 2, yOffset - 5);
        }
    }


    private void drawLinkedList(Graphics g, LinkedList<Integer> list) {
        // Implement drawing logic for linked lists
    }
}

