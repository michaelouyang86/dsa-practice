package dsa.problems.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/same-tree
public class SameTree {
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 != null) {
                return false;
            } else if (node1 != null && node2 == null) {
                return false;
            } else if (node1 != null && node2 != null && node1.val != node2.val) {
                return false;
            }
            if (node1 != null) {
                queue1.offer(node1.left);
                queue1.offer(node1.right);
            }
            if (node2 != null) {
                queue2.offer(node2.left);
                queue2.offer(node2.right);
            }
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
