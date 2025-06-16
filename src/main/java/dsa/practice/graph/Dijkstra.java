package dsa.practice.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import dsa.practice.graph.WeightedGraph.Edge;

public class Dijkstra {

    public Map<String, ShortestPath> findShortestPath(WeightedGraph graph, String start) {
        // Create data structures for Dijkstra's algorithm
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        // Initialize distances to all nodes as infinity, except the start node
        for (String nodeName : graph.getNodeNames()) {
            distances.put(nodeName, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Start processing from the start node
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) {
            String nodeName = priorityQueue.poll().name;
            // Skip if the node has already been processed
            if (visited.contains(nodeName)) {
                continue;
            }
            for (Edge edge : graph.getEdges(nodeName)) {
                String neighbor = edge.getDestination();
                int weight = edge.getDistance();
                // Skip if the neighbor has already found the shortest path
                if (visited.contains(neighbor)) {
                    continue;
                }
                int newDistance = distances.get(nodeName) + weight;
                int currentDistance = distances.get(neighbor);
                if (newDistance < currentDistance) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, nodeName);
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
            visited.add(nodeName);
        }

        // Construct the result for each node
        Map<String, ShortestPath> result = new HashMap<>();
        for (String nodeName : graph.getNodeNames()) {
            ShortestPath shortestPath = new ShortestPath();
            // Shortest distance
            shortestPath.distance = distances.get(nodeName);
            // Shortest path
            String currentNodeName = nodeName;
            while (currentNodeName != null) {
                shortestPath.path.addFirst(currentNodeName);
                currentNodeName = previous.get(currentNodeName);
            }
            result.put(nodeName, shortestPath);
        }
        return result;
    }

    private static class Node {

        private String name;
        private int distance;

        public Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static class ShortestPath {

        private int distance;
        private List<String> path = new LinkedList<>();

        public int getDistance() {
            return this.distance;
        }

        public String getPath() {
            return path.stream().collect(Collectors.joining(" -> "));
        }
    }
}
