package dataStructures.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node createNode(int val){
        return new Node(val);
    }

    void DFS(Node root){
        if(root==null){
            return;
        }

        DFS(root.left);
        DFS(root.right);
        System.out.print(root.data + " ");
    }

    void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data +" ");
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
        BinaryTree bt = new BinaryTree();

        Node root = bt.createNode(1); // level 1

        root.left = bt.createNode(2); // level 2
        root.right = bt.createNode(3);

        root.left.left = bt.createNode(4); // level 3
        root.left.right = bt.createNode(5);
        root.right.left = bt.createNode(6);
        root.right.right = bt.createNode(7);

        root.left.right.left = bt.createNode(8); // level 4
        root.right.left.left = bt.createNode(15);
        root.right.left.right = bt.createNode(9);

        bt.BFS(root);

    }
}
