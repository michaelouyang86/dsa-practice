package dsa.practice.dynamic_programming;

import java.util.Map;

public class FibonacciTopDown {

    // fib(0) = 0 (base case)
    // fib(1) = 1 (base case)
    // fib(2) = fib(1) + fib(0) = 1
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fib(int n, Map<Integer, Integer> memo) {
        // base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int result = fib(n - 1, memo) + fib(n - 2, memo);
            memo.put(n, result);
            return result;
        }
    }
}
