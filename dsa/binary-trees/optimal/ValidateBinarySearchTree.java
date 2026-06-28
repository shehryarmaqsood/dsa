// Time Complexity: O(n) - single DFS with min/max bounds
// Space Complexity: O(h) - recursion stack

package binary.trees.optimal;

/**
 * LeetCode 98 - Validate Binary Search Tree
 * Optimal Approach (DFS with Min/Max Bounds):
 * - Each node must lie strictly within (min, max) bounds.
 * - Left child: max bound becomes current node value.
 * - Right child: min bound becomes current node value.
 * - Avoids storing the full inorder list.
 */
public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Validate that all nodes in this subtree are in (min, max) range
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true; // empty subtree is valid

        if (node.val <= min || node.val >= max) {
            return false; // value violates BST bounds
        }

        // Left subtree: all values must be < node.val
        // Right subtree: all values must be > node.val
        return validate(node.left,  min,       node.val)
            && validate(node.right, node.val,  max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();

        TreeNode valid = new TreeNode(2);
        valid.left = new TreeNode(1); valid.right = new TreeNode(3);
        System.out.println(sol.isValidBST(valid)); // Expected: true

        TreeNode invalid = new TreeNode(5);
        invalid.left = new TreeNode(1); invalid.right = new TreeNode(4);
        invalid.right.left = new TreeNode(3); invalid.right.right = new TreeNode(6);
        System.out.println(sol.isValidBST(invalid)); // Expected: false
    }
}
