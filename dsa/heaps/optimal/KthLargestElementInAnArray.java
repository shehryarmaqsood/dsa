// Time Complexity: O(n log k) - each insert/poll on heap of size k is O(log k)
// Space Complexity: O(k) - heap stores only k elements

package heaps.optimal;

import java.util.PriorityQueue;

/**
 * LeetCode 215 - Kth Largest Element in an Array
 * Optimal Approach (Min-Heap of size k):
 * - Maintain a min-heap of the k largest elements seen so far.
 * - When heap exceeds k, remove the smallest (root).
 * - After processing all elements, the root is the k-th largest.
 * - O(n log k) vs O(n log n) for sorting.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        // Min-heap: smallest among top-k is always at root
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);       // add current element

            if (minHeap.size() > k) {
                minHeap.poll();       // remove smallest to keep only k largest
            }
        }

        return minHeap.peek(); // root = k-th largest overall
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray sol = new KthLargestElementInAnArray();
        System.out.println(sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));          // Expected: 5
        System.out.println(sol.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // Expected: 4
    }
}
