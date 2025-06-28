package programs.BST.BalancedBinaryTree;

class Node {
    int data;
    Node left, right;

    // Constructor to initialize node
    Node(int value) {
        this.data = value;
        left = right = null;
    }
}

public class BalancedBinaryTree {

    // Function to calculate height of the binary tree
    public static int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Function to check if tree is height-balanced
    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if current node is balanced and recursively check for left and right subtrees
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        /*
         Constructing the following tree:
                  1
                 / \
                2   3
               /
              4
             /
            5
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);

        if (isBalanced(root))
            System.out.println("The binary tree is height-balanced.");
        else
            System.out.println("The binary tree is NOT height-balanced.");
    }
}

