package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// https://leetcode.com/problems/snakes-and-ladders
public class SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        boolean fromLeft = true;
        int index = 1;
        int[] path = new int[board.length * board.length + 1];
        for (int i = board.length - 1; i >= 0; i--) {
            if (fromLeft) {
                for (int j = 0; j < board.length; j++) {
                    path[index++] = board[i][j];
                }
            } else {
                for (int j = board.length - 1; j >= 0; j--) {
                    path[index++] = board[i][j];
                }
            }
            fromLeft = !fromLeft;
        }

        int[] shortestRoll = new int[path.length];
        Arrays.fill(shortestRoll, -1);
        shortestRoll[1] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next >= path.length) {
                    continue;
                }
                next = path[next] == -1 ? next : path[next];
                if (shortestRoll[next] == -1) {
                    shortestRoll[next] = shortestRoll[current] + 1;
                    queue.offer(next);
                }
                if (next == path.length - 1) {
                    return shortestRoll[next];
                }
            }
        }

        return -1;
    }
}
