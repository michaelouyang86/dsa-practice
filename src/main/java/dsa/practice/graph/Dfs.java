package dsa.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Dfs {

    public void search(Graph graph, int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        stack.push(start);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if (!seen.contains(current)) {
                System.out.printf("%d ", current);
                seen.add(current);

                List<Integer> adjacencies = graph.getAdjacencies().get(current);
                for (int adjacency : adjacencies) {
                    if (!seen.contains(adjacency)) {
                        stack.push(adjacency);
                    }
                }
            }
        }
    }
}
