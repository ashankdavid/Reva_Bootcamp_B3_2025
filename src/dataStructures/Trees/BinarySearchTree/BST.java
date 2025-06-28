package dataStructures.Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

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

public class BST {
    private Node root;

    BST(){
        root = null;
    }

    private Node insertRec(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            root.right = insertRec(root.right, key);
        }return root;
    }

    public void insertKey(int key){
        root = insertRec(root,key);
    }

    private boolean searchRec(Node root, int key){
        if(root==null){
            return false;
        }
        if(key==root.key){
            return true;
        }
        if(key<root.key){
            return searchRec(root.left, key);
        }else{
            return searchRec(root.right, key);
        }
    }

    public boolean searchKey(int key){
        return searchRec(root, key);
    }

    Node findSuccesor(Node node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    private Node deleteRec(Node root, int key){
        if(root==null){
            return root;
        }
        if(key<root.key){
            root.left = deleteRec(root.left, key);
        } else if (key > root.key){
            root.right = deleteRec(root.right, key);
        }else{
            // Now you have found the node to be deleted
            // case 1: when the node has 0 or 1 child
            if(root.left==null) {
                return root.right;
            } else if(root.right==null){
                return root.left;
            }
            // case 2: when node has 2 children
            Node successor = findSuccesor(root.right);
            root.key = successor.key;
            root.right = deleteRec(root.right, successor.key);
        }
        return root;
    }

    public void removeKey(int key){
        root = deleteRec(root, key);
    }

    void BFS(){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.key +" ");
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }
    }

}

class DriverCode{
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertKey(100);
        bst.insertKey(50);
        bst.insertKey(150);
        bst.insertKey(30);
        bst.insertKey(70);
        bst.insertKey(130);
        bst.insertKey(170);
        bst.BFS();
        int key = 170;
//        System.out.println(bst.searchKey(key));
        System.out.println();
        System.out.println("After deletion:");
        bst.removeKey(key);
        bst.BFS();
    }
}
