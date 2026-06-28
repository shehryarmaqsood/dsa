// Time Complexity: O(n) - visit every node once
// Space Complexity: O(h) - recursion stack depth equals tree height

package binary.trees.optimal;

/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 * Optimal Approach (DFS Recursion):
 * - Depth of a node = 1 + max(depth of left, depth of right).
 * - Base case: null node has depth 0.
 * - Elegant, minimal code, O(h) space instead of O(n) for BFS.
 */
public class MaximumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // base case: empty tree has depth 0

        int leftDepth  = maxDepth(root.left);   // depth of left subtree
        int rightDepth = maxDepth(root.right);  // depth of right subtree

        return 1 + Math.max(leftDepth, rightDepth); // current node adds 1
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left  = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.maxDepth(root)); // Expected: 3
    }
}
