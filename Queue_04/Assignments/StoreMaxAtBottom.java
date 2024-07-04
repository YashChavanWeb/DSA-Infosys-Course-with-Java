package Queue_04.Assignments;

/*
 * Given a stack of integers, calculate the sum of all the integers present in the stack. Modify the stack such that the sum is present in the bottom of the stack and all the other integers are present in the stack in the same order. Implement the logic inside calculateSum() method of the Tester class.

The Stack class has been provided.
 */

class Stack {

    private int top;
    private int maxSize;
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (top >= (maxSize - 1)) {
            return true;
        }
        return false;
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++top] = data;
            return true;
        }
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]); // accessing element at position index
            }
        }
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top--];
    }
}

public class StoreMaxAtBottom {
    public static void main(String args[]) {

        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        calculateSum(stack);

        System.out.println("Updated stack");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        Stack newStack = new Stack(11); // Creating a new stack to store elements temporarily

        int addition = 0;
        System.out.println("Displaying stack elements : ");

        // Transfer elements from original stack to newStack and calculate sum
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            newStack.push(temp);
            addition += temp;
        }

        // push the sum so that it shows at the bottom
        newStack.push(addition);

        // Transfer elements back from newStack to original stack
        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
    }

}
