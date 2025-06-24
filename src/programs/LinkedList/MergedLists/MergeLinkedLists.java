package programs.LinkedList.MergedLists;

// Node class representing each node in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node with given data
    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    private Node head;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Static method to merge two sorted linked lists into a single sorted linked list
    public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while(temp1!=null && temp2!=null){
            if(temp1.data <=temp2.data){
                mergedList.insert(temp1.data);
                temp1 = temp1.next;
            }else{
                mergedList.insert(temp2.data);
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            mergedList.insert(temp1.data);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            mergedList.insert(temp2.data);
            temp2 = temp2.next;
        }

        return mergedList;
    }

    // Method to print all elements in the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate merging of two sorted linked lists
public class MergeLinkedLists {
    public static void main(String[] args) {
        // Create and populate the first sorted linked list: 1 -> 3 -> 5
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        // Create and populate the second sorted linked list: 2 -> 4 -> 6
        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        // Merge the two sorted linked lists
        LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);

        // Display the merged sorted linked list
        System.out.print("Merged Sorted Linked List: ");
        mergedList.display();
    }
}
