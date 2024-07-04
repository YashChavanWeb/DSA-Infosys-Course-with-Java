package Queue_Interface_09;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement a program to update a given stack of alphabets such that the bottom three elements are removed from bottom and placed on top with their order maintained. Implement the logic inside updateStack() method.

Test the functionalities using the main() method of the Tester class.
 */

public class BottomElementsOnTop {
    public static Deque<Character> updateStack(Deque<Character> inputStack) {

        Deque<Character> resultStack = new ArrayDeque<>();
        Deque<Character> tempStack = new ArrayDeque<>();

        for (int i = 1; i <= 2; i++) {
            resultStack.addLast(inputStack.pop());
        }

        while (!inputStack.isEmpty()) {
            tempStack.addFirst(inputStack.pop());
        }

        while (!tempStack.isEmpty()) {
            resultStack.addFirst(tempStack.pop());
        }

        return resultStack;
    }

    public static void main(String[] args) {

        Deque<Character> inputStack = new ArrayDeque<Character>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');

        Deque<Character> resultStack = updateStack(inputStack);

        System.out.println("The alphabets in updated stack are:");
        for (Character alphabet : resultStack)
            System.out.println(alphabet);
    }
}
