package dsa.practice.linear;

import java.util.NoSuchElementException;

public class Queue {
    
    private Node head;
    private Node tail;

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public int peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
