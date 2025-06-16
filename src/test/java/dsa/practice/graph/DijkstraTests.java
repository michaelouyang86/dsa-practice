package dsa.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;

import org.junit.jupiter.api.Test;

import dsa.practice.graph.Dijkstra.ShortestPath;

public class DijkstraTests {

    // Graph:
    //
    //    B---6----E
    //  2/|      / |\
    //  / |     /  | \9
    // A  5  _3/   1  C
    //  \ | /      | /3
    //  8\|/       |/
    //    D---2----F
    //
    @Test
    void testExample() {
        WeightedGraph graph = new WeightedGraph();

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 8);
        graph.addEdge("B", "D", 5);
        graph.addEdge("B", "E", 6);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 2);
        graph.addEdge("E", "F", 1);
        graph.addEdge("E", "C", 9);
        graph.addEdge("F", "C", 3);

        Dijkstra dijkstra = new Dijkstra();
        Map<String, ShortestPath> result = dijkstra.findShortestPath(graph, "A");

        assertEquals(0, result.get("A").getDistance());
        assertEquals("A", result.get("A").getPath());

        assertEquals(2, result.get("B").getDistance());
        assertEquals("A -> B", result.get("B").getPath());

        assertEquals(8, result.get("E").getDistance());
        assertEquals("A -> B -> E", result.get("E").getPath());

        assertEquals(7, result.get("D").getDistance());
        assertEquals("A -> B -> D", result.get("D").getPath());

        assertEquals(9, result.get("F").getDistance());
        assertEquals("A -> B -> D -> F", result.get("F").getPath());

        assertEquals(12, result.get("C").getDistance());
        assertEquals("A -> B -> D -> F -> C", result.get("C").getPath());
    }

    // Graph:
    //     A
    //   /   \
    // 4/     \2
    // B---5---C
    // |       |
    // |10     |3
    // D---4---E
    // |
    // |11
    // F
    @Test
    void testSimpleGraph() {
        WeightedGraph graph = new WeightedGraph();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("E", "D", 4);
        graph.addEdge("D", "F", 11);

        Dijkstra dijkstra = new Dijkstra();
        Map<String, ShortestPath> result = dijkstra.findShortestPath(graph, "A");

        assertEquals(0, result.get("A").getDistance());
        assertEquals("A", result.get("A").getPath());

        assertEquals(4, result.get("B").getDistance());
        assertEquals("A -> B", result.get("B").getPath());

        assertEquals(2, result.get("C").getDistance());
        assertEquals("A -> C", result.get("C").getPath());

        assertEquals(9, result.get("D").getDistance());
        assertEquals("A -> C -> E -> D", result.get("D").getPath());

        assertEquals(5, result.get("E").getDistance());
        assertEquals("A -> C -> E", result.get("E").getPath());

        assertEquals(20, result.get("F").getDistance());
        assertEquals("A -> C -> E -> D -> F", result.get("F").getPath());
    }

    // Graph:
    //     A
    //   /   \   ______5______
    // 1/     \5/             \
    // B---2---C---1---D---1---E---2---F
    //  \______4______/
    @Test
    void testGraphWithMultiplePaths() {
        WeightedGraph graph = new WeightedGraph();

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 1);
        graph.addEdge("B", "D", 4);
        graph.addEdge("D", "E", 1);
        graph.addEdge("C", "E", 5);
        graph.addEdge("E", "F", 2);

        Dijkstra dijkstra = new Dijkstra();
        Map<String, ShortestPath> result = dijkstra.findShortestPath(graph, "A");

        assertEquals(0, result.get("A").getDistance());
        assertEquals("A", result.get("A").getPath());

        assertEquals(1, result.get("B").getDistance());
        assertEquals("A -> B", result.get("B").getPath());

        assertEquals(3, result.get("C").getDistance());
        assertEquals("A -> B -> C", result.get("C").getPath());

        assertEquals(4, result.get("D").getDistance());
        assertEquals("A -> B -> C -> D", result.get("D").getPath());

        assertEquals(5, result.get("E").getDistance());
        assertEquals("A -> B -> C -> D -> E", result.get("E").getPath());

        assertEquals(7, result.get("F").getDistance());
        assertEquals("A -> B -> C -> D -> E -> F", result.get("F").getPath());
    }

    // Graph:
    //     A
    //   /   \
    // 2/     \3
    // B       C
    //          |
    //         1|
    //          D
    //          |
    //         4|
    //          E
    //
    // Node Z is disconnected
    @Test
    void testGraphWithDisconnectedNode() {
        WeightedGraph graph = new WeightedGraph();

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 3);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 4);
        // Z is not added at all

        Dijkstra dijkstra = new Dijkstra();
        Map<String, ShortestPath> result = dijkstra.findShortestPath(graph, "A");

        assertEquals(0, result.get("A").getDistance());
        assertEquals("A", result.get("A").getPath());

        assertEquals(2, result.get("B").getDistance());
        assertEquals("A -> B", result.get("B").getPath());

        assertEquals(3, result.get("C").getDistance());
        assertEquals("A -> C", result.get("C").getPath());

        assertEquals(4, result.get("D").getDistance());
        assertEquals("A -> C -> D", result.get("D").getPath());

        assertEquals(8, result.get("E").getDistance());
        assertEquals("A -> C -> D -> E", result.get("E").getPath());

        assertNull(result.get("Z"));
    }

    // Graph (cycle):
    //     A——1——B
    //     |     |
    //   1 |     | 1
    //     D——1——C
    //           |
    //           2
    //           E
    @Test
    void testCyclicGraph() {
        WeightedGraph graph = new WeightedGraph();

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "A", 1);
        graph.addEdge("C", "E", 2);

        Dijkstra dijkstra = new Dijkstra();
        Map<String, ShortestPath> result = dijkstra.findShortestPath(graph, "A");

        assertEquals(0, result.get("A").getDistance());
        assertEquals("A", result.get("A").getPath());

        assertEquals(1, result.get("B").getDistance());
        assertEquals("A -> B", result.get("B").getPath());

        assertEquals(2, result.get("C").getDistance());
        assertEquals("A -> B -> C", result.get("C").getPath());

        assertEquals(1, result.get("D").getDistance());
        assertEquals("A -> D", result.get("D").getPath());

        assertEquals(4, result.get("E").getDistance());
        assertEquals("A -> B -> C -> E", result.get("E").getPath());
    }
}
