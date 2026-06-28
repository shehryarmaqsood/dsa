// Time Complexity: O(n) - visit every node once via BFS
// Space Complexity: O(n) - queue holds up to one full level

package binary.trees.brute;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 * Brute Force Approach (BFS Level Counter):
 * - Perform level-order BFS and count levels.
 * - Each level processed increments depth by 1.
 */
public class MaximumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at current level
            depth++;                      // entering a new level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left  = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.maxDepth(root)); // Expected: 3
        System.out.println(sol.maxDepth(new TreeNode(1))); // Expected: 1
    }
}
