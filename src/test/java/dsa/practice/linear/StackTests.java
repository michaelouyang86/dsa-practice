package dsa.practice.linear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class StackTests {

    @Test
    void testPushAndPeek() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);

        // peek should return the top element without removing it
        assertEquals(20, stack.peek());

        // stack should not be empty
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // pop should return the top element and remove it
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        // after two pops, the top should be 1
        assertEquals(1, stack.peek());
    }

    @Test
    void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.push(100);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopOnEmptyThrowsException() {
        Stack stack = new Stack();
        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void testPeekOnEmptyThrowsException() {
        Stack stack = new Stack();
        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void testPushPopMultiple() {
        Stack stack = new Stack();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        for (int i = 4; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.isEmpty());
    }
}
