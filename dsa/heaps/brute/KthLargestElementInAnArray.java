// Time Complexity: O(n log n) - sorting the full array
// Space Complexity: O(1) - sort in place (ignoring sort internals)

package heaps.brute;

import java.util.Arrays;

/**
 * LeetCode 215 - Kth Largest Element in an Array
 * Brute Force Approach:
 * - Sort the array in descending order.
 * - Return the element at index k-1.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // sort ascending
        // k-th largest is at index (n - k) in ascending sorted array
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray sol = new KthLargestElementInAnArray();
        System.out.println(sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // Expected: 5
        System.out.println(sol.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // Expected: 4
    }
}
