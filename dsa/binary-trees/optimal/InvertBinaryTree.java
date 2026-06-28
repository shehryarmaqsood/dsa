// Time Complexity: O(n) - visit every node once via DFS
// Space Complexity: O(h) - recursion stack where h is tree height (O(log n) balanced, O(n) worst)

package binary.trees.optimal;

/**
 * LeetCode 226 - Invert Binary Tree
 * Optimal Approach (Recursive DFS):
 * - Recursively invert left and right subtrees.
 * - Swap them at the current node.
 * - Elegant and concise; same O(n) time as BFS but simpler code.
 */
public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // base case

        // Recursively invert both subtrees
        TreeNode left  = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap children
        root.left  = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree sol = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left  = new TreeNode(2); root.right = new TreeNode(7);
        root.left.left  = new TreeNode(1); root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6); root.right.right= new TreeNode(9);

        TreeNode inv = sol.invertTree(root);
        System.out.println(inv.val);        // 4
        System.out.println(inv.left.val);   // 7
        System.out.println(inv.right.val);  // 2
        // Expected inverted tree: [4,7,2,9,6,3,1]
    }
}
