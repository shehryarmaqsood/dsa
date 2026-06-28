# Linked Lists

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Remove Duplicates from Sorted List | Easy | [Link](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) |
| 2 | Linked List Cycle | Easy | [Link](https://leetcode.com/problems/linked-list-cycle/) |
| 3 | Merge Two Sorted Lists | Easy | [Link](https://leetcode.com/problems/merge-two-sorted-lists/) |

## Approach

**Remove Duplicates from Sorted List:** Brute force collects unique values into an ArrayList and rebuilds the list — O(n) space. Optimal uses a single pointer that skips duplicate nodes in place by rewiring `curr.next = curr.next.next` when values match — O(1) space.

**Linked List Cycle:** Brute force stores every visited node in a HashSet; a cycle is detected when a node is seen twice — O(n) space. Optimal uses Floyd's cycle detection (fast/slow pointers): slow moves 1 step, fast moves 2 steps; if they ever meet, a cycle exists — O(1) space.

**Merge Two Sorted Lists:** Brute force collects all values from both lists into an ArrayList, sorts it, and rebuilds — O(n log n). Optimal uses two pointers to merge in a single pass: at each step pick the smaller node from the two heads and advance that pointer — O(n) time, O(1) extra space.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Remove Duplicates | O(n) | O(n) | O(n) | O(1) |
| Linked List Cycle | O(n) | O(n) | O(n) | O(1) |
| Merge Two Sorted Lists | O(n log n) | O(n) | O(n) | O(1) |

## How to Run

```bash
cd linked-lists/brute
javac LinkedListCycle.java && java linked.lists.brute.LinkedListCycle

cd linked-lists/optimal
javac MergeTwoSortedLists.java && java linked.lists.optimal.MergeTwoSortedLists
```
