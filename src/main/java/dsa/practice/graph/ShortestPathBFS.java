package dsa.practice.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFS {

    public int[] getDistance(Graph graph, int start) {
        int[] distances = new int[graph.getAdjacencies().size()];
        Arrays.fill(distances, -1);
        distances[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> adjacencies = graph.getAdjacencies().get(node);
            for (int adjacency: adjacencies) {
                if (distances[adjacency] == -1) {
                    distances[adjacency] = distances[node] + 1;
                    queue.add(adjacency);
                }
            }
        }

        return distances;
    }
}
