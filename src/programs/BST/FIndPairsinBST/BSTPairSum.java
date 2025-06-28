package programs.BST.FIndPairsinBST;

import java.util.HashSet;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}

public class BSTPairSum {

    // Main function to find if a pair with given sum exists
    public static boolean findPair(Node root, int k) {
        HashSet<Integer> visited = new HashSet<>();
        return findPairUntil(root, k, visited);
    }

    // Helper function to recursively find the complement node
    private static boolean findPairUntil(Node root, int k, HashSet<Integer> visited) {
        if (root == null) return false;

        // Check in left subtree
        if (findPairUntil(root.left, k, visited)) return true;

        // Check for the complement
        if (visited.contains(k - root.data)) {
            System.out.println("Pair found: (" + (k - root.data) + ", " + root.data + ")");
            return true;
        }

        // Add current node value to visited
        visited.add(root.data);

        // Check in right subtree
        return findPairUntil(root.right, k, visited);
    }

    // Sample tree construction
    public static Node createSampleBST() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.right = new Node(7);
        root.left.left.left = new Node(4);
        root.right.right = new Node(15);
        root.right.right.left = new Node(13);
        return root;
    }

    // Driver Code
    public static void main(String[] args) {
        Node root = createSampleBST();

        int k1 = 14;
        System.out.println("Sum " + k1 + " -> " + findPair(root, k1)); // True

        int k2 = 20;
        System.out.println("Sum " + k2 + " -> " + findPair(root, k2)); // True

        int k3 = 10;
        System.out.println("Sum " + k3 + " -> " + findPair(root, k3)); // False
    }
}
