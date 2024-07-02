package Linked_Lists_01;

/*
 * Q.1. Given a linked list, find and return the position of a given element in the linked list. If the element is not present, return 0. Implement the logic inside findPosition() method of the Tester class.

Note: The position starts from 1.
 * 
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

class LinkedList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
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
        }

        else {
            node.setNext(this.head);
            this.head = node;
        }
    }

    public void display() {
        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
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

public class ExerciseElementAtPosition {
    public static void main(String args[]) {

        LinkedList linkedList = new LinkedList();
        linkedList.addAtEnd("AB");
        linkedList.addAtEnd("BC");
        linkedList.addAtEnd("CD");
        linkedList.addAtEnd("DE");
        linkedList.addAtEnd("EF");

        String elementToBeFound = "CD";
        int position = findPosition(elementToBeFound, linkedList.getHead());
        if (position != 0)
            System.out.println("The position of the element is " + position);
        else
            System.out.println("The element is not found!");
    }

    public static int findPosition(String element, Node head) {

        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.getData().equals(element)) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }

        return 0;
    }
}
