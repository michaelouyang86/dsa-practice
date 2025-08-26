package dsa.problems.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(n, k, 1, new LinkedList<>(), combinations);
        return combinations;
    }

    private void backtracking(int n, int k, int start, List<Integer> list, List<List<Integer>> combinations) {
        if (list.size() + (n - start + 1) < k) {
            return;
        }
        if (list.size() == k) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtracking(n, k, i + 1, list, combinations);
            list.removeLast();
        }
    }
}
