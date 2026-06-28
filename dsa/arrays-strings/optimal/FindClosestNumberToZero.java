// Time Complexity: O(n) - same linear scan but with careful tie handling
// Space Complexity: O(1) - constant extra space

package arrays.strings.optimal;

/**
 * LeetCode 2239 - Find Closest Number to Zero
 * Optimal Approach:
 * - Same O(n) as brute, but handles the tie case (positive wins) explicitly in one pass.
 * - No redundant comparisons; clean single-pass logic.
 */
public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int num : nums) {
            // Prefer num if it's strictly closer, or equal distance but positive
            if (Math.abs(num) < Math.abs(closest) ||
               (Math.abs(num) == Math.abs(closest) && num > 0)) {
                closest = num;
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
