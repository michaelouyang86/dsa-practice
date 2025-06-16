package dsa.practice.dynamic_programming;

public class FibonacciBottomUp {

    // fib(0) = 0 (base case)
    // fib(1) = 1 (base case)
    // fib(2) = fib(1) + fib(0) = 1
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] table = new int[n + 1];
            table[0] = 0;
            table[1] = 1;
            for (int i = 2; i <= n; i++) {
                table[i] = table[i - 1] + table[i - 2];
            }
            return table[n];
        }
    }
}
