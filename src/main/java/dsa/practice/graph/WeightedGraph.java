package dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {

    private Map<String, List<Edge>> edges = new HashMap<>();

    public void addEdge(String from, String to, int distance) {
        if (!edges.containsKey(from)) {
            edges.put(from, new ArrayList<>());
        }
        if (!edges.containsKey(to)) {
            edges.put(to, new ArrayList<>());
        }
        edges.get(from).add(new Edge(to, distance));
        edges.get(to).add(new Edge(from, distance));
    }

    public Set<String> getNodeNames() {
        return edges.keySet();
    }

    public List<Edge> getEdges(String nodeName) {
        return edges.get(nodeName);
    }

    public static class Edge {

        private String destination;
        private int distance;

        public Edge(String destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        public String getDestination() {
            return this.destination;
        }

        public int getDistance() {
            return this.distance;
        }
    }
}
