package dsa.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import dsa.practice.graph.AStarSearch.ShortestPath;

public class AStarSearchTests {

    AStarSearch aStarSearch = new AStarSearch();

    @Test
    void testDirectPath() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("A", "B", 5);

        Map<String, Integer> heuristic = Map.of(
            "A", 5,
            "B", 0
        );

        ShortestPath result = aStarSearch.getShortestPath(graph, heuristic, "A", "B");

        assertEquals(5, result.getDistance());
        assertEquals("A -> B", result.getPath());
        assertEquals(Set.of("A"), result.getVisited());
    }

    @Test
    void testStartEqualsGoal() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);

        Map<String, Integer> heuristic = Map.of(
            "A", 0,
            "B", 1,
            "C", 2
        );

        ShortestPath result = aStarSearch.getShortestPath(graph, heuristic, "A", "A");

        assertEquals(0, result.getDistance());
        assertEquals("A", result.getPath());
        assertEquals(Set.of(), result.getVisited());
    }

    @Test
    void testNoPath() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("C", "C", 0); // "C" is isolated

        Map<String, Integer> heuristic = Map.of(
            "A", 3,
            "B", 2,
            "C", 0
        );

        ShortestPath result = aStarSearch.getShortestPath(graph, heuristic, "A", "C");

        assertEquals(Integer.MAX_VALUE, result.getDistance());
        assertEquals("", result.getPath());
        assertEquals(Set.of("A", "B"), result.getVisited());
    }

    @Test
    void testMultiplePathsChooseBest1() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 5);
        graph.addEdge("A", "D", 2);
        graph.addEdge("D", "C", 1);

        Map<String, Integer> heuristic = Map.of(
            "A", 3,
            "B", 4,
            "C", 0,
            "D", 1
        );

        ShortestPath result = aStarSearch.getShortestPath(graph, heuristic, "A", "C");

        assertEquals(3, result.getDistance());
        assertEquals("A -> D -> C", result.getPath());
        assertEquals(Set.of("A", "D"), result.getVisited());
    }

    @Test
    void testMultiplePathsChooseBest2() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 5);

        Map<String, Integer> heuristic = Map.of(
            "A", 5,
            "B", 2,
            "C", 0
        );

        ShortestPath result = aStarSearch.getShortestPath(graph, heuristic, "A", "C");

        assertEquals(4, result.getDistance());
        assertEquals("A -> B -> C", result.getPath());
        assertEquals(Set.of("A", "B"), result.getVisited());
    }

    // Please refer to below excellent video for graph and GPS distances:
    // https://youtu.be/ySN5Wnu88nE?t=359
    @Test
    void testAStarSearch() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge("S", "A", 7);
        graph.addEdge("S", "B", 2);
        graph.addEdge("S", "C", 3);
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "D", 4);
        graph.addEdge("B", "H", 1);
        graph.addEdge("D", "F", 5);
        graph.addEdge("H", "F", 3);
        graph.addEdge("H", "G", 2);
        graph.addEdge("C", "L", 2);
        graph.addEdge("L", "I", 4);
        graph.addEdge("L", "J", 4);
        graph.addEdge("I", "J", 6);
        graph.addEdge("I", "K", 4);
        graph.addEdge("J", "K", 4);
        graph.addEdge("K", "E", 5);
        graph.addEdge("G", "E", 2);

        Map<String, Integer> toEndGpsDistances = new HashMap<>();
        toEndGpsDistances.put("S", 10);
        toEndGpsDistances.put("A", 9);
        toEndGpsDistances.put("B", 7);
        toEndGpsDistances.put("D", 8);
        toEndGpsDistances.put("H", 6);
        toEndGpsDistances.put("F", 6);
        toEndGpsDistances.put("G", 3);
        toEndGpsDistances.put("C", 8);
        toEndGpsDistances.put("L", 6);
        toEndGpsDistances.put("I", 4);
        toEndGpsDistances.put("J", 4);
        toEndGpsDistances.put("K", 3);
        toEndGpsDistances.put("E", 0);

        ShortestPath shortestPath = aStarSearch.getShortestPath(graph, toEndGpsDistances, "S", "E");

        assertEquals(7, shortestPath.getDistance());
        assertEquals("S -> B -> H -> G -> E", shortestPath.getPath());
        assertEquals(Set.of("S", "B", "H", "G"), shortestPath.getVisited());
    }
}
