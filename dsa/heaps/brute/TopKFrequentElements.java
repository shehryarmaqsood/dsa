// Time Complexity: O(n log n) - sort all elements by frequency
// Space Complexity: O(n) - frequency map and sorted list

package heaps.brute;

import java.util.*;

/**
 * LeetCode 347 - Top K Frequent Elements
 * Brute Force Approach:
 * - Count frequency of every element using a HashMap.
 * - Sort all unique elements by frequency descending.
 * - Return the first k elements.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort unique elements by frequency descending
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> freq.get(b) - freq.get(a)); // highest freq first

        // Step 3: Take first k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1}, 1)));            // [1]
    }
}
