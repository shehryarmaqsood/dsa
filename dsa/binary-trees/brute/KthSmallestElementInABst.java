// Time Complexity: O(n) - collect all nodes in inorder list
// Space Complexity: O(n) - store all values in list

package binary.trees.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 230 - Kth Smallest Element in a BST
 * Brute Force Approach:
 * - Perform inorder traversal (left-root-right) which yields sorted order for BST.
 * - Collect all values in a list and return the (k-1)th element.
 */
public class KthSmallestElementInABst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder); // fill list in sorted order
        return inorder.get(k - 1); // k is 1-indexed
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);   // visit left subtree first
        list.add(node.val);     // visit root (sorted position)
        dfs(node.right, list);  // visit right subtree
    }

    public static void main(String[] args) {
        KthSmallestElementInABst sol = new KthSmallestElementInABst();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1); root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(sol.kthSmallest(root, 1)); // Expected: 1
        System.out.println(sol.kthSmallest(root, 3)); // Expected: 3
    }
}
