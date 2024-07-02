package Queue_03;

class Queue {

    private int front;
    private int rear;
    private int maxSize;
    private int arr[];

    Queue(int maxSize) {
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
    }

    public boolean isFull() {
        if (rear == maxSize - 1) {
            return true;
        }
        return false;
    }

    public boolean enqueue(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++rear] = data;
            return true;
        }
    }

    public void display() {
        if (isEmpty())
            System.out.println("Queue is empty!");
        else {
            for (int index = front; index <= rear; index++) {
                System.out.println(arr[index]);
            }
        }
    }

    public boolean isEmpty() {
        if (front > rear)
            return true;
        return false;
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int data = arr[this.front];
            arr[front++] = Integer.MIN_VALUE;
            return data;
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}

public class EvenlyDivisibleNumbers {
    public static void main(String[] args) {

        Queue queue = new Queue(7);
        queue.enqueue(13983);
        queue.enqueue(10080);
        queue.enqueue(7113);
        queue.enqueue(2520);
        queue.enqueue(2500);

        Queue outputQueue = findEvenlyDivisibleNumbers(queue);

        System.out.println("Evenly divisible numbers:");
        outputQueue.display();

    }

    public static Queue findEvenlyDivisibleNumbers(Queue queue) {

        Queue outputQueue = new Queue(queue.getMaxSize()); // Use same maxSize for output queue

        while (!queue.isEmpty()) {

            int temp = queue.dequeue();
            boolean divisibleByAll = true;

            // Check divisibility by 1 through 9
            for (int i = 1; i <= 9; i++) {
                if (temp % i != 0) {
                    divisibleByAll = false;
                    break;
                }
            }

            // If divisible by all, enqueue to outputQueue
            if (divisibleByAll) {
                outputQueue.enqueue(temp);
            }

        }

        return outputQueue;
    }
}
