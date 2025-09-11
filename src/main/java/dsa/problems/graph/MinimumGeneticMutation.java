package dsa.problems.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// https://leetcode.com/problems/minimum-genetic-mutation
public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int distance = 0;
        int[] minDistance = new int[bank.length];
        Arrays.fill(minDistance, -1);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return distance - 1;
                }
                for (int j = 0; j < minDistance.length; j++) {
                    if (minDistance[j] == -1 && getDistance(gene, bank[j]) == 1) {
                        minDistance[j] = distance;
                        queue.offer(bank[j]);
                    }
                }
            }
        }
        return -1;
    }

    private int getDistance(String geneA, String geneB) {
        int distance = 0;
        for (int i = 0; i < 8; i++) {
            if (geneA.charAt(i) != geneB.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
