package dsa.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShortestPathBFSTests {

    ShortestPathBFS spbfs = new ShortestPathBFS();

    @Test
    public void testSingleNodeGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 0); // single node with self-loop

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
    }

    @Test
    public void testTwoConnectedNodes() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
        assertEquals(1, distance[1]);
    }

    @Test
    public void testLinearGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
        assertEquals(1, distance[1]);
        assertEquals(2, distance[2]);
        assertEquals(3, distance[3]);
    }

    @Test
    public void testGraphWithCycle() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // forms a cycle

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
        assertEquals(1, distance[1]);
        assertEquals(1, distance[2]);
    }

    @Test
    public void testDisconnectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3); // 2-3 disconnected from 0-1

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
        assertEquals(1, distance[1]);

        // nodes 2 and 3 are unreachable, should be -1
        assertEquals(-1, distance[2]);
        assertEquals(-1, distance[3]);
    }


    /*
        0
       / \
      /   \
     1-----2
     |     |
     |     |
     4-----3
    */
    @Test
    public void testComplexGraphWithCycles() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // cycle
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // another cycle

        int[] distance = spbfs.getDistance(graph, 0);
        assertEquals(0, distance[0]);
        assertEquals(1, distance[1]);
        assertEquals(1, distance[2]);
        assertEquals(2, distance[3]);
        assertEquals(2, distance[4]);
    }
}
