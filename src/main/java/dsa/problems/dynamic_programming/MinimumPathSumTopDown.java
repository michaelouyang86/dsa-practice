package dsa.problems.dynamic_programming;

// https://leetcode.com/problems/minimum-path-sum
public class MinimumPathSumTopDown {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0, memo);
    }

    private int minPathSum(int[][] grid, int currentRow, int currentCol, int[][] memo) {
        int endRow = grid.length - 1;
        int endCol = grid[0].length - 1;
        // Out of bound
        if (currentRow > endRow || currentCol > endCol) {
            return Integer.MAX_VALUE;
        }
        // Base case
        if (currentRow == endRow && currentCol == endCol) {
            return grid[endRow][endCol];
        }
        // Memo
        if (memo[currentRow][currentCol] != -1) {
            return memo[currentRow][currentCol];
        }
        // Calculate
        int goRight = minPathSum(grid, currentRow, currentCol + 1, memo);
        int goDown = minPathSum(grid, currentRow + 1, currentCol, memo);
        int result = grid[currentRow][currentCol] + Math.min(goRight, goDown);
        memo[currentRow][currentCol] = result;
        return result;
    }
}
