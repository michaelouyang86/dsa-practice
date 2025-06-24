package dsa.problems.dynamic_programming;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs
public class ClimbingStairs {
    // Constraints: 1 <= n <= 45
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return this.climbStairs(n, memo);
    }

    private int climbStairs(int remainingStair, int[] memo) {
        // Base cases
        if (remainingStair == 1) {
            return 1;
        } else if (remainingStair == 2) {
            return 2;
        }
        // Return memoized result
        if (memo[remainingStair] != -1) {
            return memo[remainingStair];
        } else {
            int result = climbStairs(remainingStair - 1, memo) + climbStairs(remainingStair - 2, memo);
            memo[remainingStair] = result;
            return result;
        }
    }
}
