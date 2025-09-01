package dsa.problems.dynamic_programming;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return minimumTotal(triangle, 0, 0, memo);
    }

    private int minimumTotal(List<List<Integer>> triangle, int row, int index, int[][] memo) {
        // base case
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(index);
        }
        // memo
        if (memo[row][index] != Integer.MAX_VALUE) {
            return memo[row][index];
        }
        // dp process
        int moveSame = minimumTotal(triangle, row + 1, index, memo);
        int moveNext = minimumTotal(triangle, row + 1, index + 1, memo);
        memo[row][index] = triangle.get(row).get(index) + Math.min(moveSame, moveNext);
        return memo[row][index];
    }
}
