package Queue_Interface_10.Exercises;

import java.util.Deque;
import java.util.ArrayDeque;

/* 
 * Merge a given queue of integers and a queue of alphabets to form a single queue based on the below mentioned rules:

Merge elements at the same position starting with the integer queue.

If one of the queues has more elements than the other, add all the additional elements at the end of the output queue.

Implement the logic inside mergeQueue() method.

Test the functionalities using the main() method of the Tester class
*/

public class MergeQueuesAlternate {

    public static Deque<Object> mergeQueue(Deque<Integer> intQueue, Deque<Character> charQueue) {

        Deque<Object> combined = new ArrayDeque<>();

        while ((!intQueue.isEmpty()) || (!charQueue.isEmpty())) {
            if ((!intQueue.isEmpty())) {
                combined.add(intQueue.poll());
            }
            if ((!charQueue.isEmpty())) {
                combined.add(charQueue.poll());
            }
        }

        return combined;
    }

    public static void main(String[] args) {

        Deque<Integer> integerQueue = new ArrayDeque<Integer>();
        integerQueue.add(3);
        integerQueue.add(6);
        integerQueue.add(9);

        Deque<Character> characterQueue = new ArrayDeque<Character>();
        characterQueue.add('a');
        characterQueue.add('e');
        characterQueue.add('i');
        characterQueue.add('o');
        characterQueue.add('u');
        characterQueue.add('b');

        Deque<Object> mergedQueue = mergeQueue(integerQueue, characterQueue);

        System.out.println("The elements in the merged queue are:");
        for (Object element : mergedQueue)
            System.out.println(element);

    }
}
