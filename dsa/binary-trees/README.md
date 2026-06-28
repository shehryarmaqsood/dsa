# Binary Trees

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Invert Binary Tree | Easy | [Link](https://leetcode.com/problems/invert-binary-tree/) |
| 2 | Maximum Depth of Binary Tree | Easy | [Link](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| 3 | Kth Smallest Element in a BST | Medium | [Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) |
| 4 | Diameter of Binary Tree | Easy | [Link](https://leetcode.com/problems/diameter-of-binary-tree/) |
| 5 | Validate Binary Search Tree | Medium | [Link](https://leetcode.com/problems/validate-binary-search-tree/) |
| 6 | Implement Trie (Prefix Tree) | Medium | [Link](https://leetcode.com/problems/implement-trie-prefix-tree/) |
| 7 | Minimum Absolute Difference in BST | Easy | [Link](https://leetcode.com/problems/minimum-absolute-difference-in-bst/) |

## Approach

**Invert Binary Tree:** Brute force uses an iterative BFS queue to swap children level by level. Optimal uses recursive DFS — at each node, swap left and right children after recursing into both subtrees. Cleaner and same O(n) complexity.

**Maximum Depth of Binary Tree:** Brute force counts tree levels with a BFS queue. Optimal uses DFS recursion: depth = 1 + max(leftDepth, rightDepth), reducing code to two lines while using O(h) stack space instead of O(n) for the queue.

**Kth Smallest in BST:** Brute force collects all values via inorder traversal into a list (sorted in BST), then returns index k-1 — O(n) time and space. Optimal uses iterative inorder with an explicit stack and stops as soon as the k-th node is visited — O(k) time, O(h) space.

**Diameter of Binary Tree:** Brute force computes left and right subtree heights at every node, calling `height()` repeatedly — O(n²). Optimal does a single DFS that computes height bottom-up while updating a global max diameter at each node — O(n).

**Validate BST:** Brute force collects the inorder traversal and checks if it is strictly increasing. Optimal passes min/max bounds down the recursion: each node must lie strictly within (min, max), which correctly handles all ancestor constraints without storing the traversal.

**Implement Trie:** Brute force stores all inserted words in an ArrayList; `search` calls `contains()` and `startsWith` does a linear scan — O(n·L) per query. Optimal builds a TrieNode tree with 26 child pointers per node; insert/search/startsWith all run in O(L) where L is the word length.

**Minimum Absolute Difference in BST:** Brute force collects all values and compares every pair — O(n²). Optimal uses inorder traversal (which gives sorted order for BST) with a `prev` pointer; minimum difference is always between adjacent inorder values — O(n).

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Invert Binary Tree | O(n) | O(n) | O(n) | O(h) |
| Maximum Depth | O(n) | O(n) | O(n) | O(h) |
| Kth Smallest in BST | O(n) | O(n) | O(k) | O(h) |
| Diameter of Binary Tree | O(n²) | O(n) | O(n) | O(h) |
| Validate BST | O(n) | O(n) | O(n) | O(h) |
| Implement Trie | O(n·L) per query | O(n·L) | O(L) per op | O(n·L) |
| Min Abs Diff in BST | O(n²) | O(n) | O(n) | O(h) |

*h = tree height; O(log n) balanced, O(n) worst case*

## How to Run

```bash
cd binary-trees/brute
javac InvertBinaryTree.java && java binary.trees.brute.InvertBinaryTree

cd binary-trees/optimal
javac ImplementTrie.java && java binary.trees.optimal.ImplementTrie
```
