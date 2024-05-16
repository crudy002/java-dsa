package main.java.ui;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DataStructuresApp extends JFrame {
	private JPanel mainPanel;
	private JTextArea codeArea;
	private JTextArea consoleArea;
	private JComboBox<String> dataStructureList;
	private JPanel contentPanel;
	private DataStructurePanel visualPanel;

	public DataStructuresApp() {
		
		super("Java Data Structures and Algorithms Explorer");
		
		FlatLightLaf.setup();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600); // Adjust size to accommodate visualization
		setLocationRelativeTo(null);

		visualPanel = new DataStructurePanel();


		// Navigation panel
		JPanel navPanel = new JPanel(new GridLayout(3, 1));
		JButton btnDataStructures = new JButton("Data Structures");
		JButton btnAlgorithms = new JButton("Algorithms");
		JButton lookAndFeelToggle = new JButton("Toggle Dark Mode");
		lookAndFeelToggle.addActionListener(
				e -> toggleTheme(e)
				);
		navPanel.add(btnDataStructures);
		navPanel.add(btnAlgorithms);
		navPanel.add(lookAndFeelToggle);

		// Setup for main content panel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(visualPanel, BorderLayout.NORTH); // Add visual panel at the top or as needed
		
		codeArea = new JTextArea(10, 50);
		codeArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(codeArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		// Setup data structure selection panel
		JPanel dsPanel = new JPanel(new BorderLayout());
		dataStructureList = new JComboBox<>(new String[] { "Array", "Linked List", "Stack", "Queue", "Tree" });
		dataStructureList.setVisible(false); // Initially hidden
		dataStructureList.addActionListener(e -> updateCodeArea(dataStructureList.getSelectedItem().toString()));
		dsPanel.add(dataStructureList, BorderLayout.NORTH);
		dsPanel.add(mainPanel, BorderLayout.CENTER);

		// Console area
		consoleArea = new JTextArea(5, 50);
		JScrollPane consoleScrollPane = new JScrollPane(consoleArea);
		dsPanel.add(consoleScrollPane, BorderLayout.SOUTH);

		// Adding to frame
		add(navPanel, BorderLayout.WEST);
		contentPanel = dsPanel; // To switch visibility
		add(contentPanel, BorderLayout.CENTER);

		// Action listeners for navigation buttons
		btnDataStructures.addActionListener(e -> {
			dataStructureList.setVisible(true);
			displayContent("Data Structures");
		});
		btnAlgorithms.addActionListener(e -> {
			dataStructureList.setVisible(false);
			displayContent("Algorithms");
		});
		lookAndFeelToggle.addActionListener(e -> {
			dataStructureList.setVisible(false);
			displayContent("Algorithms");
		});
	}

	private void displayContent(String type) {
		codeArea.setText("Displaying content for: " + type);
		consoleArea.setText("Execution results or interactive console");
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

	private void updateCodeArea(String dataStructure) {
		String definition = "";
		String javaCode = "";
		String operations = "";

		switch (dataStructure) {
		case "Array":
			int[] array = {1, 2, 3, 4, 5}; // Example data
            visualPanel.setDataStructure("Array", array);
			definition = "An array is a fixed-size collection of elements of the same type.";
			javaCode = "int[] arr = new int[5];";
			operations = "Access via index, length property, iterate with for-loop.";
			break;
		case "Linked List":
			definition = "A linked list consists of nodes where each node contains a data field and a reference/link to the next node.";
			javaCode = "LinkedList<Integer> list = new LinkedList<>();";
			operations = "Add, remove, find elements; iterate using while-loop.";
			break;
		case "Stack":
			definition = "A stack follows last in, first out (LIFO) principle.";
			javaCode = "Stack<Integer> stack = new Stack<>();";
			operations = "Push, pop, peek operations.";
			break;
		case "Queue":
			definition = "A queue follows first in, first out (FIFO) principle.";
			javaCode = "Queue<Integer> queue = new LinkedList<>();";
			operations = "Enqueue, dequeue, peek operations.";
			break;
		case "Tree":
			definition = "A tree is a nonlinear data structure, with a root value and subtrees of children with a parent node.";
			javaCode = "class TreeNode { int value; TreeNode left; TreeNode right; }\nTreeNode root = new TreeNode();";
			operations = "Insert, search, traverse (in-order, pre-order, post-order).";
			break;
		default:
			definition = "Select a data structure from the list above.";
			javaCode = "";
			operations = "";
			break;
		}

		codeArea.setText(
				"Definition: " + definition + "\n\nJava Code:\n" + javaCode + "\n\nOperations:\n" + operations);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			DataStructuresApp app = new DataStructuresApp();
			app.setVisible(true);
		});
	}
}
