package dsa.practice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Bfs {

    public void search(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        queue.add(start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (!seen.contains(current)) {
                System.out.printf("%d ", current);
                seen.add(current);

                List<Integer> adjacencies = graph.getAdjacencies().get(current);
                for (int adjacency : adjacencies) {
                    if (!seen.contains(adjacency)) {
                        queue.add(adjacency);
                    }
                }
            }
        }
    }
}
