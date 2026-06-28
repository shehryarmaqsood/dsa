// Time Complexity: O(n^2) - check every pair of indices
// Space Complexity: O(1) - no extra data structure

package hash.tables.brute;

/**
 * LeetCode 1 - Two Sum
 * Brute Force Approach:
 * - Try every pair (i, j) where i < j.
 * - Return indices when nums[i] + nums[j] == target.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // found the pair
                }
            }
        }
        return new int[]{}; // no solution (guaranteed not to happen per problem constraints)
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result1[0] + ", " + result1[1]); // Expected: 0, 1

        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result2[0] + ", " + result2[1]); // Expected: 1, 2
    }
}
