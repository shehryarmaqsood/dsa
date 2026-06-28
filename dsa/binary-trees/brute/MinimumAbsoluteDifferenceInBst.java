// Time Complexity: O(n^2) - compare all pairs of inorder values
// Space Complexity: O(n) - store all values in list

package binary.trees.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 530 - Minimum Absolute Difference in BST
 * Brute Force Approach:
 * - Collect all node values via inorder traversal.
 * - Compare every pair to find minimum absolute difference. O(n^2) pairs.
 */
public class MinimumAbsoluteDifferenceInBst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        int minDiff = Integer.MAX_VALUE;
        // Compare every pair — O(n^2)
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                minDiff = Math.min(minDiff, Math.abs(values.get(i) - values.get(j)));
            }
        }
        return minDiff;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBst sol = new MinimumAbsoluteDifferenceInBst();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2); root.right = new TreeNode(6);
        root.left.left = new TreeNode(1); root.left.right = new TreeNode(3);
        System.out.println(sol.getMinimumDifference(root)); // Expected: 1
    }
}
