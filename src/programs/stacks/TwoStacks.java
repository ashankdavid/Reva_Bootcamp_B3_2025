package programs.stacks;

public class TwoStacks {
    int[] arr;
    int size;
    int top1, top2;

    public TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    // Push to Stack1
    void push1(int x) {
        if (top1 + 1 < top2) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow by element: " + x + " in Stack 1");
        }
    }

    // Push to Stack2
    void push2(int x) {
        if (top2 - 1 > top1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow by element: " + x + " in Stack 2");
        }
    }

    // Pop from Stack1
    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            System.out.println("Stack Underflow in Stack 1");
            return -1;
        }
    }

    // Pop from Stack2
    int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            System.out.println("Stack Underflow in Stack 2");
            return -1;
        }
    }

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks(5);

        ts.push1(1);
        ts.push2(2);
        ts.push1(3);
        ts.push2(4);
        ts.push1(5);
        ts.push2(6); // should show overflow

        System.out.println("Popped from stack1: " + ts.pop1());
        System.out.println("Popped from stack2: " + ts.pop2());
    }
}

