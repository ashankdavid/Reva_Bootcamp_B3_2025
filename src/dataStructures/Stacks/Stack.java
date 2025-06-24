package dataStructures.Stacks;

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    void push(int val){
        if(top == size-1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = val;
    }

    void pop(){
        if(top == -1){
            System.out.println("Stack Undeflow");
            return;
        }
        top--;
    }

    int Top(){
        if(top == -1){
            System.out.println("Stack Undeflow");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top == -1;
    }
}

class DriverCode{
    public static void main(String[] args) {
        Stack st = new Stack(10);
        st.push(10);
        st.push(10);
        st.push(10);
        st.push(10);
        st.push(10);
        st.push(10);
    }
}
