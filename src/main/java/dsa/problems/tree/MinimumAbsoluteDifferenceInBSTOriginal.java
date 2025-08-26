package dsa.problems.tree;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class MinimumAbsoluteDifferenceInBSTOriginal {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);

        int min = Integer.MAX_VALUE;
        int previous = list.removeFirst();
        while (!list.isEmpty()) {
            int current = list.removeFirst();
            if (current - previous < min) {
                min = current - previous;
            }
            previous = current;
        }
        return min;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            inOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inOrder(node.right, list);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
