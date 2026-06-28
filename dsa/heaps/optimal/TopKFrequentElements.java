// Time Complexity: O(n log k) - heap of size k; better than O(n log n) sort
// Space Complexity: O(n) - frequency map + heap

package heaps.optimal;

import java.util.*;

/**
 * LeetCode 347 - Top K Frequent Elements
 * Optimal Approach (Min-Heap of size k):
 * - Count frequencies with a HashMap.
 * - Maintain a min-heap of size k keyed by frequency.
 * - When heap exceeds k, remove the least frequent element.
 * - Result: heap contains the k most frequent elements.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap ordered by frequency (smallest freq at top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int key : freq.keySet()) {
            minHeap.offer(key);         // add element

            if (minHeap.size() > k) {
                minHeap.poll();         // remove least frequent
            }
        }

        // Step 3: Extract result from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1}, 1)));            // [1]
    }
}
