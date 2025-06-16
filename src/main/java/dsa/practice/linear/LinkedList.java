package dsa.practice.linear;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    // Appends the specified element to the end of this list.
    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    // Inserts the specified element at the specified position in this list.
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            this.add(value);
        } else if (index == 0) {
            Node node = new Node(value);
            node.next = head;
            head.pre = node;
            head = node;
            size++;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node node = new Node(value);
            node.next = current.next;
            current.next.pre = node;
            current.next = node;
            node.pre = current;
            size++;
        }
    }

    // Returns the element at the specified position in this list.
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // Removes the element at the specified position in this list.
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.pre;
            tail.next = null;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            current.next.pre = current;
        }
        size--;
    }

    public int size() {
        return this.size;
    }

    private class Node {
        int value;
        Node pre;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
