public class Stack {
    int[] arr;
    int topOfStack;

    public Stack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfStack != arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The Stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return -1;
        } else {
            int topStack = arr[topOfStack];
            return topStack;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return -1;
        } else {
            return arr[topOfStack];
        }
    }
}