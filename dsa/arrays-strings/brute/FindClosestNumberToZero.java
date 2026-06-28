// Time Complexity: O(n) - single linear scan
// Space Complexity: O(1) - constant extra space

package arrays.strings.brute;

/**
 * LeetCode 2239 - Find Closest Number to Zero
 * Brute Force Approach:
 * - Iterate through all numbers tracking the one with minimum absolute value.
 * - On a tie, prefer the positive number.
 */
public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int closest = nums[0]; // start with the first element as candidate

        for (int i = 1; i < nums.length; i++) {
            // Update if current element is closer to zero
            if (Math.abs(nums[i]) < Math.abs(closest)) {
                closest = nums[i];
            }
            // Tie-breaking rule: if same distance, prefer the positive one
            else if (Math.abs(nums[i]) == Math.abs(closest) && nums[i] > closest) {
                closest = nums[i];
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        FindClosestNumberToZero sol = new FindClosestNumberToZero();
        System.out.println(sol.findClosestNumber(new int[]{-4, -2, 1, 4, 8})); // Expected: 1
        System.out.println(sol.findClosestNumber(new int[]{2, -1, 1}));         // Expected: 1
    }
}
