package Linked_Lists_01;

/*
 * 
 * Given a linked list, left and right shift the list. Implement the functionalities inside the methods described below.

Method Description

shiftListLeft(LinkedList linkedList, int n)

Left shift the given linked list by n number of times
shiftListRight(LinkedList linkedList, int n)

Right shift the given linked list by n number of times
The LinkedList and Node classes have been provided.
 */

class Node {

    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}

public class AssignLeftRightShift {

    static class LinkedList {

        private Node head;
        private Node tail;

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getHead() {
            return this.head;
        }

        public Node getTail() {
            return this.tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public void addAtEnd(String data) {
            Node node = new Node(data);

            if (this.head == null) {
                this.head = this.tail = node;
            } else {
                this.tail.setNext(node);

                this.tail = node;
            }
        }

        public void addAtBeginning(String data) {
            Node node = new Node(data);

            if (this.head == null) {
                this.head = this.tail = node;
            } else {
                node.setNext(this.head);
                this.head = node;
            }
        }

        public void display() {
            Node temp = this.head;

            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            System.out.println("null");
        }

        public Node find(String data) {
            Node temp = this.head;

            while (temp != null) {
                if (temp.getData().equals(data))
                    return temp;
                temp = temp.getNext();
            }
            return null;
        }

        public void insert(String data, String dataBefore) {
            Node node = new Node(data);

            if (this.head == null)
                this.head = this.tail = node;
            else {
                Node nodeBefore = this.find(dataBefore);
                if (nodeBefore != null) {
                    node.setNext(nodeBefore.getNext());
                    nodeBefore.setNext(node);
                    if (nodeBefore == this.tail)
                        this.tail = node;
                } else
                    System.out.println("Node not found");
            }
        }

        public void delete(String data) {

            if (this.head == null)
                System.out.println("List is empty");
            else {
                Node node = this.find(data);

                if (node == null)
                    System.out.println("Node not found");

                if (node == this.head) {
                    this.head = this.head.getNext();
                    node.setNext(null);

                    if (node == this.tail)
                        tail = null;
                } else {
                    Node nodeBefore = null;
                    Node temp = this.head;
                    while (temp != null) {
                        if (temp.getNext() == node) {
                            nodeBefore = temp;
                            break;
                        }
                        temp = temp.getNext();
                    }

                    nodeBefore.setNext(node.getNext());

                    if (node == this.tail)
                        this.tail = nodeBefore;
                    node.setNext(null);
                }
            }
        }
    }

    public static void shiftListLeft(LinkedList linkedList, int n) {
        if (linkedList.getHead() == null || n <= 0) {
            return; // No need to shift if list is empty or n <= 0
        }

        Node current = linkedList.getHead();
        int count = 1;

        // Traverse to find the (n+1)th node
        while (count < n && current != null) {
            current = current.getNext();
            count++;
        }

        if (current == null || current.getNext() == null) {
            return; // If current is null or current's next is null, no shift needed
        }

        // New head of the list after shifting
        Node newHead = current.getNext();
        linkedList.getTail().setNext(linkedList.getHead());
        linkedList.setHead(newHead);

        // cleaning up the memory
        current.setNext(null);
    }

    public static void shiftListRight(LinkedList linkedList, int n) {
        if (linkedList.getHead() == null || n <= 0) {
            return; // No need to shift if list is empty or n <= 0
        }

        Node current = linkedList.getHead();
        int length = 1;

        // Calculate the length of the list
        while (current.getNext() != null) {
            current = current.getNext();
            length++;
        }

        // Connect the last node to the head to make it circular
        linkedList.getTail().setNext(linkedList.getHead());

        // Calculate the position from which to split
        n = n % length;
        int splitPosition = length - n;

        current = linkedList.getHead();
        for (int i = 1; i < splitPosition; i++) {
            current = current.getNext();
        }

        // New head after the split
        Node newHead = current.getNext();
        current.setNext(null);
        linkedList.setHead(newHead);

        // Set the tail to the new end of the list
        linkedList.setTail(current);
    }

    public static void main(String args[]) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addAtEnd("ABC");
        linkedList1.addAtEnd("DFG");
        linkedList1.addAtEnd("XYZ");
        linkedList1.addAtEnd("EFG");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAtEnd("ABC");
        linkedList2.addAtEnd("DFG");
        linkedList2.addAtEnd("XYZ");
        linkedList2.addAtEnd("EFG");

        System.out.println("Initial List");
        linkedList1.display();

        System.out.println("\nList after left shifting by 2 positions");
        shiftListLeft(linkedList1, 2);
        linkedList1.display();

        System.out.println("\nInitial List");
        linkedList2.display();

        System.out.println("\nList after right shifting by 2 positions");
        shiftListRight(linkedList2, 3);
        linkedList2.display();
    }
}
