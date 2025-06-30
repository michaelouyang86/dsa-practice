package dsa.problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-cycle-in-a-graph
public class LongestCycleInAGraph {

    private int longestCycle = -1;
    private Map<Integer, Integer> depthMap = new HashMap<>();

    public int longestCycle(int[] edges) {
        Graph graph = new Graph();
        for (int node = 0; node < edges.length; node++) {
            if (edges[node] != -1) {
                graph.addEdge(node, edges[node]);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> onPath = new HashSet<>();
        for (int node = 0; node < edges.length; node++) {
            if (!visited.contains(node)) {
                dfs(node, graph, visited, onPath, 0);
            }
        }

        return longestCycle;
    }

    private void dfs(int node, Graph graph, Set<Integer> visited, Set<Integer> onPath, int depth) {
        visited.add(node);
        onPath.add(node);
        depthMap.put(node, depth);

        for (int neighbor : graph.getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, onPath, depth + 1);
            } else if (onPath.contains(neighbor)) {
                // contains cycle
                int tmpCycleLength = depth - depthMap.get(neighbor) + 1;
                if (tmpCycleLength > longestCycle) {
                    longestCycle = tmpCycleLength;
                }
            }
        }

        onPath.remove(node);
    }

    private static class Graph {
        private Map<Integer, List<Integer>> edges = new HashMap<>();

        public void addEdge(int from, int to) {
            edges.putIfAbsent(from, new ArrayList<>());
            edges.get(from).add(to);
        }

        public List<Integer> getNeighbors(int node) {
            return edges.getOrDefault(node, Collections.emptyList());
        }
    }
}
