package dsa.practice.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciBottomUpTests {

    FibonacciBottomUp fibonacciBottomUp = new FibonacciBottomUp();

    @Test
    void testFibZero() {
        assertEquals(0, fibonacciBottomUp.fib(0));
    }

    @Test
    void testFibOne() {
        assertEquals(1, fibonacciBottomUp.fib(1));
    }

    @Test
    void testFibSmallNumber() {
        assertEquals(5, fibonacciBottomUp.fib(5));
    }

    @Test
    void testFibLargerNumber1() {
        assertEquals(55, fibonacciBottomUp.fib(10));
    }

    @Test
    void testFibLargerNumber2() {
        assertEquals(832040, fibonacciBottomUp.fib(30));
    }
}
