package dsa.problems.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepthOriginal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(root, 1);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                depthMap.put(node.left, depthMap.get(node) + 1);
                queue.offer(node.left);
            }
            if (node.right != null) {
                depthMap.put(node.right, depthMap.get(node) + 1);
                queue.offer(node.right);
            }
        }

        return depthMap.values()
            .stream()
            .max(Integer::compare)
            .orElseThrow();
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
