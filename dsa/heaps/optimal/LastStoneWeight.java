// Time Complexity: O(n log n) - each offer/poll is O(log n)
// Space Complexity: O(n) - heap stores all stones

package heaps.optimal;

import java.util.PriorityQueue;
import java.util.Collections;

/**
 * LeetCode 1046 - Last Stone Weight
 * Optimal Approach (Max-Heap):
 * - Use a max-heap (negate values in Java's min-heap) to always get two heaviest in O(log n).
 * - Eliminates O(n log n) sort on every iteration; reduces to O(log n) per smash.
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        // Max-heap: use reverseOrder comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone); // insert all stones
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest stone
            int x = maxHeap.poll(); // second heaviest

            if (y != x) {
                maxHeap.offer(y - x); // push remaining fragment
            }
            // if equal, both destroyed
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight sol = new LastStoneWeight();
        System.out.println(sol.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // Expected: 1
        System.out.println(sol.lastStoneWeight(new int[]{1}));                 // Expected: 1
    }
}
