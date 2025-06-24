package dataStructures.LinkedList.Singly;

class Node{
    char data;
    Node next;
    Node prev;

    Node(char data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL {
    Node head;
    DLL(){
        head = null;
    }

    void insertAtHead(char val){
        Node n = new Node(val);
        if(head!=null){
            head.prev = n;
        }
        n.next = head;
        head = n;
    }

    void rotateByN(int N){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;

        while(N-- > 0){
            head = head.next;
            temp = temp.next;
        }

        temp.next = null;
        head.prev = null;

    }

    void displayLL() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class DriverCode{
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtHead('e');
        dll.insertAtHead('d');
        dll.insertAtHead('c');
        dll.insertAtHead('b');
        dll.insertAtHead('a');
        dll.displayLL();
        int N = 4;
        dll.rotateByN(N);
        dll.displayLL();
    }
}