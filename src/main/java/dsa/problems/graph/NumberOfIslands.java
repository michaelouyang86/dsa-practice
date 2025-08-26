package dsa.problems.graph;

// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslands++;
                    explore(grid, visited, i, j);
                }
            }
        }

        return numIslands;
    }

    private void explore(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        // left
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            explore(grid, visited, i, j - 1);
        }
        // right
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            explore(grid, visited, i, j + 1);
        }
        // up
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            explore(grid, visited, i - 1, j);
        }
        // down
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            explore(grid, visited, i + 1, j);
        }
    }
}
