// Time Complexity: O(n) - inorder traversal visits every node
// Space Complexity: O(n) - store inorder values in list

package binary.trees.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 98 - Validate Binary Search Tree
 * Brute Force Approach:
 * - Perform inorder traversal; for a valid BST the result must be strictly increasing.
 * - Collect all values then verify they are strictly sorted.
 */
public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Check strictly increasing order
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false; // equal or decreasing value violates BST
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
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
