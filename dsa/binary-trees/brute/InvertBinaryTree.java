// Time Complexity: O(n) - visit every node once via BFS
// Space Complexity: O(n) - queue holds up to n/2 nodes at a time

package binary.trees.brute;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 226 - Invert Binary Tree
 * Brute Force Approach (Iterative BFS):
 * - Use a queue to do level-order traversal.
 * - At each node, swap its left and right children.
 */
public class InvertBinaryTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Swap left and right children
            TreeNode temp  = node.left;
            node.left      = node.right;
            node.right     = temp;

            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    // Helper to print tree in level order
    static void printLevel(TreeNode root) {
        if (root == null) { System.out.println("null"); return; }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            sb.append(n.val).append(" ");
            if (n.left  != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        InvertBinaryTree sol = new InvertBinaryTree();
        // Tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left  = new TreeNode(2); root.right = new TreeNode(7);
        root.left.left  = new TreeNode(1); root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6); root.right.right= new TreeNode(9);

        printLevel(sol.invertTree(root)); // Expected: 4 7 2 9 6 3 1
    }
}
