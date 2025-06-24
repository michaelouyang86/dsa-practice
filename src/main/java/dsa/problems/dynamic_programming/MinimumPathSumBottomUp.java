package dsa.problems.dynamic_programming;

// https://leetcode.com/problems/minimum-path-sum
public class MinimumPathSumBottomUp {
    public int minPathSum(int[][] grid) {
        // Table
        int[][] table = new int[grid.length][grid[0].length];

        // Target
        table[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];

        // Last row
        for (int i = grid[0].length - 2; i >= 0; i--) {
            table[grid.length - 1][i] = grid[grid.length - 1][i] + table[grid.length - 1][i + 1];
        }

        // Last column
        for (int i = grid.length - 2; i >= 0; i--) {
            table[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + table[i + 1][grid[0].length - 1];
        }

        // Others
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                table[i][j] = grid[i][j] + Math.min(table[i][j + 1], table[i + 1][j]);
            }
        }

        return table[0][0];
    }
}
