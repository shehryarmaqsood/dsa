// Time Complexity: O(n) - single inorder pass
// Space Complexity: O(h) - recursion stack

package binary.trees.optimal;

/**
 * LeetCode 530 - Minimum Absolute Difference in BST
 * Optimal Approach (Inorder with Previous Pointer):
 * - In BST, inorder gives sorted order so minimum difference is always between adjacent values.
 * - Track previous node during inorder; compute diff at each step.
 * - Avoids storing all values; O(n) time, O(h) space.
 */
public class MinimumAbsoluteDifferenceInBst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null; // previous node in inorder traversal

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev    = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left); // go left first

        // Compare with previous inorder node (adjacent in sorted order)
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node; // update previous pointer

        inorder(node.right); // go right
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBst sol = new MinimumAbsoluteDifferenceInBst();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2); root.right = new TreeNode(6);
        root.left.left = new TreeNode(1); root.left.right = new TreeNode(3);
        System.out.println(sol.getMinimumDifference(root)); // Expected: 1
    }
}
