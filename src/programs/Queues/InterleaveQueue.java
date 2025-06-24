package programs.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {
    public static void interleaveQueue(Queue<Integer> q) {
        int n = q.size() / 2;
        Queue<Integer> temp = new LinkedList<>();

        // Step 1: Push first half to temp queue
        for (int i = 0; i < n; i++) {
            temp.add(q.remove());
        }

        // Step 2: Interleave both halves
        while (!temp.isEmpty()) {
            q.add(temp.remove()); // From first half
            q.add(q.remove());    // From second half
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        interleaveQueue(q);

        System.out.println("Interleaved Queue: " + q);
    }
}


