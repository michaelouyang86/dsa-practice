package dsa.practice.hierarchical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeapTests {

    private Heap heap;

    @BeforeEach
    void setUp() {
        heap = new Heap(); // Assuming default capacity = 5
    }

    @Test
    void testAddAndPeek() {
        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(5, heap.peek(), "Peek should return the smallest value in a min-heap");
    }

    @Test
    void testPoll() {
        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(5, heap.poll(), "First poll should return 5");
        assertEquals(10, heap.poll(), "Second poll should return 10");
        assertEquals(20, heap.poll(), "Third poll should return 20");

        assertThrows(NoSuchElementException.class, heap::poll);
    }

    @Test
    void testPeekEmptyHeap() {
        assertThrows(NoSuchElementException.class, heap::peek);
    }

    @Test
    void testPollEmptyHeap() {
        assertThrows(NoSuchElementException.class, heap::poll);
    }

    @Test
    void testCapacityExpansion() {
        heap.add(40);
        heap.add(10);
        heap.add(30);
        heap.add(20);
        heap.add(5);  // initial capacity reached
        heap.add(1);  // should trigger resize
        heap.add(50); // check if still works

        assertEquals(1, heap.peek(), "After capacity expansion, min should still be correct");

        // Verify full order
        assertEquals(1, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(10, heap.poll());
        assertEquals(20, heap.poll());
        assertEquals(30, heap.poll());
        assertEquals(40, heap.poll());
        assertEquals(50, heap.poll());
    }
}
