package programs.stacks;

// Custom stack implementation using arrays in Java
class MyStack {
    char[] data;
    int capacity;
    int top_index;

    // Constructor
    public MyStack(int cap) {
        capacity = cap;
        data = new char[capacity];
        top_index = -1;
    }

    public boolean isEmpty() {
        return top_index == -1;
    }

    public void push(char val) {
        if (top_index == capacity - 1) {
            System.out.println("Stack Overflow: Cannot push more elements.");
            return;
        }
        data[++top_index] = val;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop from empty stack.");
            return '\0';
        }
        return data[top_index--];
    }
}

public class BalancedParentheses {

    public static boolean isBalanced(String expression) {
        MyStack stack = new MyStack(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = { "()", "(())", "(()())", "((()))", "(()", "())", "" };

        for (String expr : expressions) {
            System.out.println("Expression: " + expr + " is balanced? " + (isBalanced(expr) ? "Yes" : "No"));
        }
    }
}

