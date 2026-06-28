// Time Complexity: O(n) - single pass with O(1) average HashSet operations
// Space Complexity: O(n) - storing elements in the HashSet

package hash.tables.optimal;

import java.util.HashSet;

/**
 * LeetCode 217 - Contains Duplicate
 * Optimal Approach (HashSet):
 * - Insert each element into a HashSet.
 * - If an element already exists in the set, we found a duplicate immediately.
 * - Avoids sorting; reduces time from O(n log n) to O(n).
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num); // record element
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
