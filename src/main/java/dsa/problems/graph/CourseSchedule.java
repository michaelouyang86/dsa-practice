package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/course-schedule
public class CourseSchedule {
    // Kahn's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create indegree array
        int[] indegree = new int[numCourses];

        // Create graph and fill indegree
        Graph graph = new Graph();
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            graph.addEdge(prerequisite[1], prerequisite[0]);
        }

        // Add courses with no prerequisites to the queue (indegree 0)
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Start processing the queue
        int taken = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            taken++;
            for (int neighbor : graph.getNeighbors(currentCourse)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return taken == numCourses;
    }

    private static class Graph {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        public void addEdge(int from, int to) {
            if (!edges.containsKey(from)) {
                edges.put(from, new ArrayList<>());
            }
            edges.get(from).add(to);
        }

        public List<Integer> getNeighbors(int node) {
            return edges.getOrDefault(node, Collections.emptyList());
        }
    }
}
