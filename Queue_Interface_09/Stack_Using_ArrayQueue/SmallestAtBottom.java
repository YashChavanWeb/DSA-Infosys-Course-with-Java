package Queue_Interface_09.Stack_Using_ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestAtBottom {

    // comparing peek element of temp stack with the peek element of the stack

    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        Deque<Integer> tempStack = new ArrayDeque<>();

        while (!inputStack.isEmpty()) {
            int current = inputStack.pop();

            // Transfer elements from tempStack back to inputStack as needed
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                inputStack.push(tempStack.pop());
            }

            // Push current element onto tempStack
            tempStack.push(current);
        }

        return tempStack;

    }

    public static void main(String[] args) {

        Deque<Integer> inputStack = new ArrayDeque<Integer>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);

        Deque<Integer> updatedStack = changeSmallest(inputStack);

        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
