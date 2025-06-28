package programs.BST.BinaryTreeValidator;

class Node{
    int key;
    Node left;
    Node right;

    Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BST {
    private Node root;
    Long prevVal;

    BST(){
        root = null;
        prevVal = null;
    }

    // Helper Function for Insert Main Function
    private Node insertRec(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            root.right = insertRec(root.right, key);
        }return root;
    }

    // Insert Main Function
    public void insert(int key){
        root = insertRec(root, key);
    }

    public boolean isBST() {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;
        if (node.key <= min || node.key >= max) return false;

        return isBSTUtil(node.left, min, node.key) &&
                isBSTUtil(node.right, node.key, max);
    }

    // Optimized BST check using inorder traversal (no extra space)
    public boolean isBSTUsingInorder() {
        prevVal = null;  // Reset before each run
        return inorderCheck(root);
    }

    private boolean inorderCheck(Node node) {
        if (node == null) return true;

        // Left subtree
        if (!inorderCheck(node.left)) return false;

        // Current node check
        if (prevVal != null && node.key <= prevVal) return false;
        prevVal = (long) node.key;  // Update previous value

        // Right subtree
        return inorderCheck(node.right);
    }
}

public class BinaryTreeValidator {
    public static void main(String[] args) {
        BST bt = new BST();
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values) {
            bt.insert(val);
        }

        System.out.println("Method 1 (Range Check): Is BST? " + bt.isBST());
        System.out.println("Method 2 (Optimized Inorder DFS): Is BST? " + bt.isBSTUsingInorder());

//        // Introduce violation manually
//        bt.root.left.right = new Node(22); // Invalid
//        System.out.println("After violation:");
//        System.out.println("Method 1: " + bt.isBST());
//        System.out.println("Method 2: " + bt.isBSTUsingInorder());
    }
}


