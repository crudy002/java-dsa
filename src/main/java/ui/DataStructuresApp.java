package main.java.ui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class DataStructuresApp extends JFrame {
    private JPanel mainPanel;
    private RSyntaxTextArea codeArea;
    private JTextPane consoleArea;
    private JComboBox<String> dataStructureList;
    private JPanel contentPanel;
    private JPanel visualPanel;
    private JLabel imageLabel;
    
    private HashMap<String, byte[]> notesMap; // Store notes as byte arrays
    private String currentDataStructure;


    public DataStructuresApp() {
        super("Java Data Structures and Algorithms Explorer");

        FlatLightLaf.setup();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Create visual panel
        visualPanel = new JPanel();

        imageLabel = new JLabel();
        visualPanel.add(imageLabel);
        // Load the initial image
        updateImage("Array.png");

        // Set the layout of the panel
        visualPanel.setLayout(new FlowLayout());

        // Navigation panel
        JPanel navPanel = new JPanel(new GridLayout(3, 1));
        JButton btnDataStructures = new JButton("Data Structures");
        JButton btnAlgorithms = new JButton("Algorithms");
        JButton lookAndFeelToggle = new JButton("Toggle Dark Mode");
        lookAndFeelToggle.addActionListener(this::toggleTheme);
        navPanel.add(btnDataStructures);
        navPanel.add(btnAlgorithms);
        navPanel.add(lookAndFeelToggle);
        
        currentDataStructure = "Array";
        notesMap = new HashMap<>();
        mainPanel = new JPanel(new BorderLayout());

        codeArea = new RSyntaxTextArea(20, 60);
        codeArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        RTextScrollPane scrollPane = new RTextScrollPane(codeArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Setup data structure selection panel
        JPanel dsPanel = new JPanel(new BorderLayout());
        dataStructureList = new JComboBox<>(new String[]{"Array", "Linked List", "Stack", "Queue", "Tree"});
        dataStructureList.setVisible(false); // Initially hidden
        dataStructureList.addActionListener(e -> updateCodeArea(dataStructureList.getSelectedItem().toString()));
        dsPanel.add(dataStructureList, BorderLayout.NORTH);
        dsPanel.add(mainPanel, BorderLayout.CENTER);

        
        // Console area
        
        JPanel southPanel = new JPanel(new BorderLayout());
        
        consoleArea = new JTextPane();
        JScrollPane scrollPane2 = new JScrollPane(consoleArea);
        southPanel.add(scrollPane2, BorderLayout.CENTER);
       
        
        JPanel panel = new JPanel();
        JButton boldButton = new JButton("Bold");
        boldButton.addActionListener(e -> RichTextEditor.setBold(consoleArea));
        panel.add(boldButton);

        JButton italicButton = new JButton("Italic");
        italicButton.addActionListener(e -> RichTextEditor.setItalic(consoleArea));
        panel.add(italicButton);

        JButton codeButton = new JButton("Code");
        codeButton.addActionListener(e -> RichTextEditor.setCode(consoleArea));
        panel.add(codeButton);

        JButton regularButton = new JButton("Regular");
        regularButton.addActionListener(e -> RichTextEditor.setRegular(consoleArea));
        panel.add(regularButton);

        JButton exportButton = new JButton("Export");
        exportButton.addActionListener(e -> RichTextEditor.exportText(consoleArea));
        panel.add(exportButton);

        southPanel.add(panel, BorderLayout.NORTH);
        
        dsPanel.add(southPanel, BorderLayout.SOUTH);

        // Adding to frame
        add(navPanel, BorderLayout.WEST);
        contentPanel = dsPanel; // To switch visibility

     // Wrap the mainPanel and visualPanel in a JSplitPane
        //JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, visualPanel, contentPanel);
        JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, contentPanel, southPanel);
        verticalSplitPane.setResizeWeight(0.5); // Smaller weight for the visual panel

        add(verticalSplitPane, BorderLayout.CENTER);


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
        
     // Set preferred sizes for panels
     visualPanel.setPreferredSize(new Dimension(800, 200)); // Smaller height for visual panel
     contentPanel.setPreferredSize(new Dimension(800, 600)); // Larger height for content panel

    }

    private void displayContent(String type) {
        saveCurrentNotes();
        codeArea.setText("Displaying content for: " + type);
        consoleArea.setText("Execution results or interactive console");
        loadNotes(type);
        currentDataStructure = type;
    }

    private void toggleTheme(ActionEvent e) {
        try {
            if (UIManager.getLookAndFeel() instanceof FlatLightLaf) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                try {
                    Theme theme = Theme.load(getClass().getResourceAsStream(
                          "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
                    theme.apply(codeArea);
                 } catch (IOException ioe) { // Never happens
                    ioe.printStackTrace();
                 }
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
                try {
                    Theme theme = Theme.load(getClass().getResourceAsStream(
                          "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                    theme.apply(codeArea);
                 } catch (IOException ioe) { // Never happens
                    ioe.printStackTrace();
                 }
            }
            // Update UI components to reflect the change
            SwingUtilities.updateComponentTreeUI(((JComponent) e.getSource()).getTopLevelAncestor());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateCodeArea(String dataStructure) {
    	saveCurrentNotes();
        String definition = "";
        String javaCode = "";
        String operations = "";

        switch (dataStructure) {
            case "Array":
                int[] array = {1, 2, 3, 4, 5}; // Example data
                updateImage("Array.png");
                definition = "An array is a fixed-size collection of elements of the same type.";
                javaCode = "int[] arr = new int[5];";
                operations = "Access via index, length property, iterate with for-loop.";
                break;
            case "Linked List":
                updateImage("LinkedList.png");
                definition = "A linked list consists of nodes where each node contains a data field and a reference/link to the next node.";
                javaCode = "LinkedList<Integer> list = new LinkedList<>();";
                operations = "Add, remove, find elements; iterate using while-loop.";
                break;
            case "Stack":
            	updateImage("Stack.png");
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

        codeArea.setText("Definition: " + definition + "\n\nJava Code:\n" + javaCode + "\n\nOperations:\n" + operations);
        loadNotes(dataStructure);
        currentDataStructure = dataStructure;
    }

    private void updateImage(String imageName) {
        String imagePath = "/resources/" + imageName.toLowerCase().replace(" ", "");
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));

        // Resize the image icon if necessary
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(400, 200, Image.SCALE_SMOOTH); // Adjust the size as needed
        imageIcon = new ImageIcon(newimg);

        imageLabel.setIcon(imageIcon);
    }
    
    private void saveCurrentNotes() {
        try {
            RTFEditorKit rtfEditorKit = new RTFEditorKit();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            rtfEditorKit.write(outputStream, consoleArea.getDocument(), 0, consoleArea.getDocument().getLength());
            notesMap.put(currentDataStructure, outputStream.toByteArray());
        } catch (IOException | BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    
    private void loadNotes(String dataStructure) {
        byte[] notes = notesMap.get(dataStructure);
        if (notes != null) {
            try {
                RTFEditorKit rtfEditorKit = new RTFEditorKit();
                ByteArrayInputStream inputStream = new ByteArrayInputStream(notes);
                StyledDocument doc = (StyledDocument) rtfEditorKit.createDefaultDocument();
                rtfEditorKit.read(inputStream, doc, 0);
                consoleArea.setDocument(doc);
            } catch (IOException | BadLocationException ex) {
                ex.printStackTrace();
            }
        } else {
        	consoleArea.setText("");
        }
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DataStructuresApp app = new DataStructuresApp();
            app.setVisible(true);
        });
    }
}
