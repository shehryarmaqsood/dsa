// Time Complexity: O(n) - single pass with a start pointer
// Space Complexity: O(n) - output list

package arrays.strings.optimal;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 228 - Summary Ranges
 * Optimal Approach (Single Pass):
 * - Track the start of each range; advance until the sequence breaks.
 * - Build output in one linear pass, no nested loops.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int start = i; // remember index of range start

            // Advance while next element is consecutive
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // Append single number or range
            if (i == start) {
                result.add(String.valueOf(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[i]);
            }
            i++; // move past current range
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sol = new SummaryRanges();
        System.out.println(sol.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));    // [0->2, 4->5, 7]
        System.out.println(sol.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})); // [0, 2->4, 6, 8->9]
    }
}
