# Heaps (Priority Queues)

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Last Stone Weight | Easy | [Link](https://leetcode.com/problems/last-stone-weight/) |
| 2 | Kth Largest Element in an Array | Medium | [Link](https://leetcode.com/problems/kth-largest-element-in-an-array/) |
| 3 | Top K Frequent Elements | Medium | [Link](https://leetcode.com/problems/top-k-frequent-elements/) |

## Approach

**Last Stone Weight:** Brute force sorts the list on every iteration to find the two heaviest stones — O(n² log n) overall. Optimal uses a max-heap (Java's PriorityQueue with reverseOrder): the two heaviest stones are always available in O(log n) per poll, reducing total time to O(n log n).

**Kth Largest Element:** Brute force sorts the array in ascending order and returns `nums[n-k]` — O(n log n). Optimal maintains a min-heap of exactly k elements; when the heap exceeds k, the smallest is removed. After all elements are processed, the root is the k-th largest — O(n log k) time, O(k) space.

**Top K Frequent Elements:** Brute force counts frequencies with a HashMap, sorts all unique elements by frequency, and returns the first k — O(n log n). Optimal counts frequencies then maintains a min-heap of size k keyed by frequency; elements with lower frequency are evicted, leaving only the top k — O(n log k).

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Last Stone Weight | O(n² log n) | O(n) | O(n log n) | O(n) |
| Kth Largest Element | O(n log n) | O(1) | O(n log k) | O(k) |
| Top K Frequent Elements | O(n log n) | O(n) | O(n log k) | O(n) |

## How to Run

```bash
cd heaps/brute
javac LastStoneWeight.java && java heaps.brute.LastStoneWeight

cd heaps/optimal
javac KthLargestElementInAnArray.java && java heaps.optimal.KthLargestElementInAnArray
```
