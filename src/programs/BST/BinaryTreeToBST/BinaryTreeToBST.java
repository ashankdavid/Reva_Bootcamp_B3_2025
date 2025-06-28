package programs.BST.BinaryTreeToBST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeToBST {
    int index = 0;

    // Inorder traversal to store node values
    void storeInorder(Node root, List<Integer> values) {
        if (root == null) return;

        storeInorder(root.left, values);
        values.add(root.data);
        storeInorder(root.right, values);
    }

    // Inorder traversal to convert tree to BST using sorted values
    void convertToBST(Node root, List<Integer> values) {
        if (root == null) return;

        convertToBST(root.left, values);
        root.data = values.get(index++);
        convertToBST(root.right, values);
    }

    // Utility function to print inorder traversal
    void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeToBST tree = new BinaryTreeToBST();

        // Example binary tree (not BST)
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        System.out.println("Original Tree (Inorder):");
        tree.printInorder(root);

        // Step 1: Store values
        List<Integer> values = new ArrayList<>();
        tree.storeInorder(root, values);

        // Step 2: Sort the values
        Collections.sort(values);

        // Step 3: Convert to BST
        tree.index = 0;
        tree.convertToBST(root, values);

        System.out.println("\n\nConverted BST (Inorder):");
        tree.printInorder(root);
    }
}

