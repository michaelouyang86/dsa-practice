package dsa.problems.tree;

// https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newLeft = null;
        TreeNode newRight = null;
        if (root.left != null) {
            newRight = invertTree(root.left);
        }
        if (root.right != null) {
            newLeft = invertTree(root.right);
        }
        root.left = newLeft;
        root.right = newRight;
        return root;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
