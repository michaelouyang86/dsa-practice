package dsa.practice.linear;

import java.util.NoSuchElementException;

public class Stack {

    private Node top;

    public void push(int value) {
        if (top == null) {
            top = new Node(value);
        } else {
            Node node = new Node(value);
            node.next = top;
            top = node;
        }
    }

    public int pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
