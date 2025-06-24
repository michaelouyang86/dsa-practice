package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule
public class CourseScheduleOriginal {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create graph
        Graph graph = new Graph();
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[1], prerequisite[0]);
        }

        // DFS
        Set<Integer> taken = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (graph.getPrerequisites(course).size() == 0) {
                queue.offer(course);
            }
            while (!queue.isEmpty()) {
                int currentCourse = queue.poll();
                if (taken.contains(currentCourse)) {
                    continue;
                }
                if (taken.containsAll(graph.getPrerequisites(currentCourse))) {
                    taken.add(currentCourse);
                    for (int nextCourse : graph.getNextCourses(currentCourse)) {
                        if (!taken.contains(nextCourse)) {
                            queue.offer(nextCourse);
                        }
                    }
                }
            }
        }

        return taken.size() == numCourses;
    }

    private static class Graph {
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();
        Map<Integer, List<Integer>> prerequisites = new HashMap<>();

        public void addEdge(int from, int to) {
            if (!nextCourses.containsKey(from)) {
                nextCourses.put(from, new ArrayList<>());
            }
            nextCourses.get(from).add(to);

            if (!prerequisites.containsKey(to)) {
                prerequisites.put(to, new ArrayList<>());
            }
            prerequisites.get(to).add(from);
        }

        public List<Integer> getNextCourses(int course) {
            return nextCourses.getOrDefault(course, Collections.emptyList());
        }

        public List<Integer> getPrerequisites(int course) {
            return prerequisites.getOrDefault(course, Collections.emptyList());
        }
    }
}
