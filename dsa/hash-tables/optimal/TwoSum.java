// Time Complexity: O(n) - single pass with O(1) HashMap operations
// Space Complexity: O(n) - storing elements in the HashMap

package hash.tables.optimal;

import java.util.HashMap;

/**
 * LeetCode 1 - Two Sum
 * Optimal Approach (HashMap - One Pass):
 * - For each number, compute the complement (target - num).
 * - Check if the complement already exists in the map.
 * - If yes, return both indices. If no, store current number with its index.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // what we need to find

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // found complement earlier
            }
            map.put(nums[i], i); // store current number and its index
        }
        return new int[]{}; // no solution found
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result1[0] + ", " + result1[1]); // Expected: 0, 1

        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result2[0] + ", " + result2[1]); // Expected: 1, 2
    }
}
