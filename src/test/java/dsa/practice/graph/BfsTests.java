package dsa.practice.graph;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BfsTests {
    /* 
           0
          / \
         1   2
        /     \
       3       4
      /         \
     6           5
   */
    @Test
    void testBfs1() {
        List<String> validOutputs = new ArrayList<>();
        validOutputs.add("0 1 2 3 4 6 5 "); // current result

        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Bfs bfs = new Bfs();
        bfs.search(graph, 0);

        System.setOut(System.out);
        assertTrue(validOutputs.contains(outContent.toString()));
    }

    /*
          0
        / | \
       1  2  3
      / \     \
     4   5     6
         |
         7
   */
    @Test
    void testBfs2() {
        List<String> validOutputs = new ArrayList<>();
        validOutputs.add("0 1 2 3 4 5 6 7 "); // current result

        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(5, 7);
        graph.addEdge(3, 6);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Bfs bfs = new Bfs();
        bfs.search(graph, 0);

        System.setOut(System.out);
        assertTrue(validOutputs.contains(outContent.toString()));
    }
}
