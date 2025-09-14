package dsa.problems.graph;

// https://leetcode.com/problems/redundant-connection
public class RedundantConnection {
    // Disjoint Set (Union-Find)
    private int[] size;
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        size = new int[edges.length + 1];
        parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private boolean union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        // Cannot union if they are already in the same set
        if (rootA == rootB) {
            return false;
        }

        // Union
        if (size[rootA] >= size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return true;
    }

    private int find(int node) {
        int root = node;
        while (root != parent[root]) {
            root = parent[root];
        }
        return root;
    }
}
