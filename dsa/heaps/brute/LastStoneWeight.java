// Time Complexity: O(n^2 log n) - sort on every iteration
// Space Complexity: O(1) - sort in place

package heaps.brute;

import java.util.Arrays;

/**
 * LeetCode 1046 - Last Stone Weight
 * Brute Force Approach:
 * - Sort the array on every iteration to find the two heaviest stones.
 * - Smash them according to the rules; repeat until one or zero stones remain.
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        // Convert to ArrayList for easy removal
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            java.util.Collections.sort(list); // sort ascending each iteration
            int n = list.size();

            int y = list.get(n - 1); // heaviest
            int x = list.get(n - 2); // second heaviest

            list.remove(n - 1);
            list.remove(n - 2);

            if (y != x) {
                list.add(y - x); // remaining stone of weight y-x
            }
            // if equal, both destroyed — nothing added
        }

        return list.isEmpty() ? 0 : list.get(0);
    }

    public static void main(String[] args) {
        LastStoneWeight sol = new LastStoneWeight();
        System.out.println(sol.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // Expected: 1
        System.out.println(sol.lastStoneWeight(new int[]{1}));                 // Expected: 1
    }
}
