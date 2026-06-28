// Time Complexity: O(k) - stop as soon as k-th element found
// Space Complexity: O(h) - stack holds at most h nodes (h = tree height)

package binary.trees.optimal;

import java.util.Stack;

/**
 * LeetCode 230 - Kth Smallest Element in a BST
 * Optimal Approach (Iterative Inorder - Early Stop):
 * - Use an explicit stack to simulate inorder traversal.
 * - Stop the moment we've visited k nodes.
 * - Avoids storing all n elements; stops at k.
 */
public class KthSmallestElementInABst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop(); // process this node (in sorted order)
            k--;                // count down

            if (k == 0) return curr.val; // found the k-th smallest

            curr = curr.right; // move to right subtree
        }
        return -1; // should never reach here per problem constraints
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
