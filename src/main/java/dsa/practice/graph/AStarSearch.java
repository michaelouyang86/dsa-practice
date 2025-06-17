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

public class AStarSearch {

    public ShortestPath getShortestPath(WeightedGraph graph, Map<String, Integer> toEndGpsDistances, String start, String end) {
        // Create data structures for A* search algorithm
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.toEndHeuristicDistance));

        // Initialize distances to all nodes as infinity, except the start node
        for (String nodeName : graph.getNodeNames()) {
            distances.put(nodeName, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Start processing from the start node
        priorityQueue.add(new Node(start, toEndGpsDistances.get(start)));
        while(!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.name == end) {
                break;
            }
            // Skip if the node has already found the shortest path
            if (visited.contains(currentNode.name)) {
                continue;
            }
            for (Edge edge : graph.getEdges(currentNode.name)) {
                String neighbor = edge.getDestination();
                int neighborDistance = edge.getDistance();
                // Skip if the neighbor has already found the shortest path
                if (visited.contains(neighbor)) {
                    continue;
                }
                int newShortestDistance = distances.get(currentNode.name) + neighborDistance;
                if (newShortestDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newShortestDistance);
                    previous.put(neighbor, currentNode.name);
                    priorityQueue.add(new Node(neighbor, newShortestDistance + toEndGpsDistances.get(neighbor)));
                }
            }
            visited.add(currentNode.name);
        }

        // Construct the result
        ShortestPath shortestPath = new ShortestPath();
        // Shortest distance
        shortestPath.distance = distances.get(end);
        // Shortest path
        if (shortestPath.distance != Integer.MAX_VALUE) {
            String nodeName = end;
            while (nodeName != null) {
                shortestPath.path.addFirst(nodeName);
                nodeName = previous.get(nodeName);
            }
        }
        // For testing purposes only
        shortestPath.visited = visited;
        return shortestPath;
    }

    private static class Node {
        private String name;
        private int toEndHeuristicDistance;

        public Node(String name, int toEndHeuristicDistance) {
            this.name = name;
            this.toEndHeuristicDistance = toEndHeuristicDistance;
        }
    }

    public static class ShortestPath {
        private int distance;
        private List<String> path = new LinkedList<>();
        // For testing purposes only
        private Set<String> visited;

        public int getDistance() {
            return this.distance;
        }

        public String getPath() {
            return path.stream().collect(Collectors.joining(" -> "));
        }

        public Set<String> getVisited() {
            return this.visited;
        }
    }
}
