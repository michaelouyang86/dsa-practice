package dsa.practice.hash;

import java.util.Objects;

public class HashMap {

    private int capacity = 16;
    private Node[] table = new Node[capacity];

    public void put(String key, String value) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        int index = Math.abs(hashCode % capacity);
        if (table[index] == null) {
            table[index] = new Node(key, value);
        } else {
            Node current = table[index];
            // Update
            do {
                if (Objects.equals(key, current.key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            } while (current != null);
            // Add
            Node node = new Node(key, value);
            node.next = table[index];
            table[index] = node;
        }
    }

    public String get(String key) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        int index = Math.abs(hashCode % capacity);
        if (table[index] != null) {
            Node current = table[index];
            do {
                if (Objects.equals(key, current.key)) {
                    return current.value;
                }
                current = current.next;
            } while (current != null);
        }
        return null;
    }

    public void remove(String key) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        int index = Math.abs(hashCode % capacity);
        if (table[index] != null) {
            Node current = table[index];
            // Head
            if (Objects.equals(key, current.key)) {
                table[index] = current.next;
                return;
            }
            // Not head
            do {
                if (Objects.equals(key, current.next.key)) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            } while (current.next != null);
        }
    }

    private class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
