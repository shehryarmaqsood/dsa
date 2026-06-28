// Time Complexity: O(n^2) - height computed separately for each node
// Space Complexity: O(n) - recursion stack

package binary.trees.brute;

/**
 * LeetCode 543 - Diameter of Binary Tree
 * Brute Force Approach:
 * - For each node, compute height of left and right subtrees.
 * - Diameter through this node = leftHeight + rightHeight.
 * - Take max across all nodes. Redundant height computations make this O(n^2).
 */
public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // Diameter passing through root
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        int throughRoot = leftHeight + rightHeight;

        // Diameter may be entirely in left or right subtree
        int leftDiam  = diameterOfBinaryTree(root.left);
        int rightDiam = diameterOfBinaryTree(root.right);

        return Math.max(throughRoot, Math.max(leftDiam, rightDiam));
    }

    // Compute height of a subtree (number of edges to deepest leaf)
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sol.diameterOfBinaryTree(root)); // Expected: 3
    }
}
