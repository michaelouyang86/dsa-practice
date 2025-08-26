package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands
public class NumberOfIslandsOriginal {

    private int[] parent;

    public int numIslands(char[][] grid) {
        parent = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int index = getIndex(grid, i, j);
                parent[index] = index;
            }
        }

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int index = getIndex(grid, i, j);
                    if (parent[index] == index) {
                        numIslands++;
                        explore(grid, index);
                    }
                }
            }
        }
        return numIslands;
    }

    private int getIndex(char[][] grid, int i, int j) {
        return i * grid[0].length + j;
    }

    private int getI(char[][] grid, int index) {
        return index / grid[0].length;
    }

    private int getJ(char[][] grid, int index) {
        return index % grid[0].length;
    }

    private void explore(char[][] grid, int root) {
        boolean[] visited = new boolean[grid.length * grid[0].length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (visited[index]) {
                continue;
            }
            int i = getI(grid, index);
            int j = getJ(grid, index);
            // left
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                int leftIndex = getIndex(grid, i, j - 1);
                parent[leftIndex] = index;
                queue.offer(leftIndex);
            }
            // right
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                int rightIndex = getIndex(grid, i, j + 1);
                parent[rightIndex] = index;
                queue.offer(rightIndex);
            }
            // up
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                int upIndex = getIndex(grid, i - 1, j);
                parent[upIndex] = index;
                queue.offer(upIndex);
            }
            // down
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                int downIndex = getIndex(grid, i + 1, j);
                parent[downIndex] = index;
                queue.offer(downIndex);
            }
            visited[index] = true;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            { '1','1','1','1','0' },
            { '1','1','0','1','0' },
            { '1','1','0','0','0' },
            { '0','0','0','0','0' }
        };

        NumberOfIslandsOriginal numberOfIslands = new NumberOfIslandsOriginal();
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
