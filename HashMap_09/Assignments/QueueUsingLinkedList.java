package HashMap_09.Assignments;

import java.util.*;

/*
 * Implement the functionalities of a queue by using a LinkedList.  

 */

class Queue {
    int maxSize;
    List<String> queue = new ArrayList<>();

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public Boolean isEmpty() {
        if (queue.size() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isFull() {
        if (queue.size() >= maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(String data) {
        if (isFull()) {
            System.out.println("Overflow");
        } else {
            queue.add(data);
            // queue.addLast(data);
        }
    }

    public void dequeue() {
        int i = 0;
        if (isEmpty()) {
            System.out.println("Underflow");
        } else {
            queue.remove(i++);
            // queue.removeFirst();
        }
    }

    public List<String> getQueue() {
        return queue;
    }

}

public class QueueUsingLinkedList {
    public static void main(String arga[]) {
        Queue queue = new Queue(5);

        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.getQueue());
    }
}
