package dsa.practice.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class FibonacciTopDownTests {

    FibonacciTopDown fibonacciTopDown = new FibonacciTopDown();

    @Test
    void testFibZero() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(0, fibonacciTopDown.fib(0, memo));
    }

    @Test
    void testFibOne() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(1, fibonacciTopDown.fib(1, memo));
    }

    @Test
    void testFibSmallNumber() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(5, fibonacciTopDown.fib(5, memo));
    }

    @Test
    void testFibLargerNumber1() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(55, fibonacciTopDown.fib(10, memo));
    }

    @Test
    void testFibLargerNumber2() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(832040, fibonacciTopDown.fib(30, memo));
    }

    @Test
    void testFibWithPreFilledMemo() {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(9, 34); // fib(9)
        memo.put(8, 21); // fib(8)
        assertEquals(55, fibonacciTopDown.fib(10, memo)); // fib(10) = 34 + 21
    }
}
