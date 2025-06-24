package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/course-schedule-ii
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create indegree and graph
        int[] indegree = new int[numCourses];
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
        int index = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int currrentCourse = queue.poll();
            order[index++] = currrentCourse;
            for (int neighbor : graph.getNeighbors(currrentCourse)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
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
