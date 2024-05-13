package main.java;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeSearch {
    private TreeNode root;

    // Insert a value into the BST
    public void insert(int val) {
        root = insertRecursive(root, val);
    }
    
    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }
        
        return root;
    }

    // Search for a value in the BST
    public boolean search(int val) {
        return searchRecursive(root, val);
    }
    
    private boolean searchRecursive(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        
        if (val == root.val) {
            return true;
        }
        
        if (val < root.val) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        
        // Insert values into the tree
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        
        // Search for values in the tree
        System.out.println(tree.search(4)); // Should print true
        System.out.println(tree.search(6)); // Should print false
    }
}

