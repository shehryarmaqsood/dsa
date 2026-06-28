// Time Complexity: O(n) - single DFS pass, each node visited once
// Space Complexity: O(h) - recursion stack

package binary.trees.optimal;

/**
 * LeetCode 543 - Diameter of Binary Tree
 * Optimal Approach (Single DFS with Global Max):
 * - Compute height bottom-up; while returning, update a global max diameter.
 * - diameter = left height + right height at each node.
 * - No redundant height calls — each node computed exactly once.
 */
public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int maxDiameter = 0; // global max updated during DFS

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        dfs(root);
        return maxDiameter;
    }

    // Returns height of subtree rooted at node
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftHeight  = dfs(node.left);  // height of left subtree
        int rightHeight = dfs(node.right); // height of right subtree

        // Update global diameter: path through this node
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight); // return height to parent
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
