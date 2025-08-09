package dsa.problems.dynamic_programming;

// https://leetcode.com/problems/unique-paths-ii
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];

        // bottom-right corner
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0) {
            table[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        }

        for (int j = obstacleGrid[0].length - 2; j >= 0; j--) {
            if (obstacleGrid[obstacleGrid.length - 1][j] == 0) {
                table[obstacleGrid.length - 1][j] = table[obstacleGrid.length - 1][j + 1];
            } else {
                table[obstacleGrid.length - 1][j] = 0;
            }
        }

        for (int i = obstacleGrid.length - 2; i >= 0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length - 1] == 0) {
                table[i][obstacleGrid[0].length - 1] = table[i + 1][obstacleGrid[0].length - 1];
            } else {
                table[i][obstacleGrid[0].length - 1] = 0;
            }
        }

        // dp process
        for (int i = obstacleGrid.length - 2; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    table[i][j] = table[i + 1][j] + table[i][j + 1];
                } else {
                    table[i][j] = 0;
                }
            }
        }

        return table[0][0];
    }
}
