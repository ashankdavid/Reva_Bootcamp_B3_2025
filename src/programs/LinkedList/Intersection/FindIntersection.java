package programs.LinkedList.Intersection;

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    void append(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    Node getTail() {
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        return current;
    }

    void intersect(LinkedList other, int pos) {
        Node tail = getTail();
        Node intersectNode = other.head;
        while (pos > 0 && intersectNode != null) {
            intersectNode = intersectNode.next;
            pos--;
        }
        if (tail != null) {
            tail.next = intersectNode;
        }
    }
}

public class FindIntersection {

    public static Node findIntersection(Node list1, Node list2) {
        Node temp1 = list1;
        Node temp2 = list2;
        while(temp1!=temp2){
            if(temp1!=null){
                temp1 = temp1.next;
            }else{
                temp1 = list2;
            }

            if(temp2!=null){
                temp2 = temp2.next;
            }else{
                temp2 = list1;
            }
        }
        return temp1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        LinkedList list2 = new LinkedList();
        list2.append(2);
        list2.append(4);

        LinkedList intersectionPoint = new LinkedList();
        intersectionPoint.append(6);
        intersectionPoint.append(7);

        list1.intersect(intersectionPoint, 0);
        list2.intersect(intersectionPoint, 0);

        Node intersection = findIntersection(list1.head, list2.head);
        if (intersection != null) {
            System.out.println("Intersection point data: " + intersection.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
