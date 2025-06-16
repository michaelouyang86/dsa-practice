package dsa.practice.linear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListTests {

    @Test
    void testAddAndGet() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtIndex() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(1, 15); // Insert 15 at index 1
        list.add(0, 5); // Insert 5 at index 0

        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(15, list.get(2));
        assertEquals(20, list.get(3));
        assertEquals(4, list.size());
    }

    @Test
    void testRemoveAtIndex() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1); // Remove element at index 1

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());

        list.add(5);
        list.add(10);
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    void testGetWithInvalidIndex() {
        LinkedList list = new LinkedList();
        list.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testAddWithInvalidIndex() {
        LinkedList list = new LinkedList();
        list.add(50);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, 60));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 70));
    }

    @Test
    void testRemoveWithInvalidIndex() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testAddAtBeginningAndEnd() {
        LinkedList list = new LinkedList();
        list.add(0, 100); // Add at head
        list.add(1, 200); // Add at tail

        assertEquals(100, list.get(0));
        assertEquals(200, list.get(1));
    }
}
