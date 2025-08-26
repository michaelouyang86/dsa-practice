package dsa.problems.tree;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class MinimumAbsoluteDifferenceInBST {

    private Integer previousVal = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        if (previousVal != null) {
            minDiff = Math.min(minDiff, current.val - previousVal);
        }
        previousVal = current.val;
        inOrder(current.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
