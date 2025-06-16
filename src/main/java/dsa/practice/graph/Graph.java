package dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Integer, List<Integer>> adjacencies = new HashMap<>();

    public void addEdge(int origin, int destination) {
        if (!adjacencies.containsKey(origin)) {
            adjacencies.put(origin, new ArrayList<>());
        }
        if (!adjacencies.containsKey(destination)) {
            adjacencies.put(destination, new ArrayList<>());
        }
        adjacencies.get(origin).add(destination);
        adjacencies.get(destination).add(origin);
    }

    public Map<Integer, List<Integer>> getAdjacencies() {
        return adjacencies;
    }
}
