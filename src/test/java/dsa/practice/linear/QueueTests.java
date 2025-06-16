package dsa.practice.linear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class QueueTests {

    @Test
    void testAddAndPeek() {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);

        // peek should return the first added element
        assertEquals(10, queue.peek());

        // queue should not be empty
        assertFalse(queue.isEmpty());
    }

    @Test
    void testRemove() {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // remove should return and remove the front element
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());

        // peek should now return the last remaining element
        assertEquals(3, queue.peek());
    }

    @Test
    void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());

        queue.add(42);
        assertFalse(queue.isEmpty());

        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testRemoveOnEmptyThrowsException() {
        Queue queue = new Queue();
        assertThrows(NoSuchElementException.class, queue::remove);
    }

    @Test
    void testPeekOnEmptyThrowsException() {
        Queue queue = new Queue();
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void testAddRemoveMultiple() {
        Queue queue = new Queue();

        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(i, queue.remove());
        }

        assertTrue(queue.isEmpty());
    }
}
