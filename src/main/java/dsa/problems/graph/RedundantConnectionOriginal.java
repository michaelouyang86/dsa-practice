package dsa.problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/redundant-connection
public class RedundantConnectionOriginal {
    public int[] findRedundantConnection(int[][] edges) {
        Graph graph = new Graph();
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
            if (graph.containsCycle()) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private static class Graph {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        public void addEdge(int from, int to) {
            edges.putIfAbsent(from, new ArrayList<>());
            edges.putIfAbsent(to, new ArrayList<>());
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        private List<Integer> getNeighbors(int node) {
            return edges.getOrDefault(node, Collections.emptyList());
        }

        private Set<Integer> getAllNodes() {
            return edges.keySet();
        }

        public boolean containsCycle() {
            Set<Integer> visited = new HashSet<>();
            for (int node : getAllNodes()) {
                if (!visited.contains(node) && containsCycle(node, -1, visited)) {
                    return true;
                }
            }
            return false;
        }

        private boolean containsCycle(int node, int parent, Set<Integer> visited) {
            visited.add(node);
            for (int neighbor : getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    if (containsCycle(neighbor, node, visited)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true;
                }
            }
            return false;
        }
    }
}
