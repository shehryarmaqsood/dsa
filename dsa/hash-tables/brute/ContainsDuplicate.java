// Time Complexity: O(n log n) - sorting the array
// Space Complexity: O(1) - sort in place (ignoring sort stack space)

package hash.tables.brute;

import java.util.Arrays;

/**
 * LeetCode 217 - Contains Duplicate
 * Brute Force Approach:
 * - Sort the array; duplicates will be adjacent.
 * - Scan sorted array and check if any two consecutive elements are equal.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // sort so duplicates become adjacent

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) { // adjacent equal means duplicate
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 1}));    // Expected: true
        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 4}));    // Expected: false
        System.out.println(sol.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
