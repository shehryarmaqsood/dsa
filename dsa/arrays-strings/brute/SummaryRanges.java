// Time Complexity: O(n^2) - checking every pair
// Space Complexity: O(n) - output list

package arrays.strings.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 228 - Summary Ranges
 * Brute Force Approach:
 * - For each start position, scan forward to find the end of the consecutive range.
 * - O(n^2) due to nested scanning, though in practice it's often near O(n).
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i]; // beginning of a range
            int j = i;

            // Scan forward while consecutive numbers continue
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }

            // Build the range string
            if (nums[j] == start) {
                result.add(String.valueOf(start));       // single number
            } else {
                result.add(start + "->" + nums[j]);      // range "start->end"
            }

            i = j + 1; // jump to element after current range
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sol = new SummaryRanges();
        System.out.println(sol.summaryRanges(new int[]{0, 1, 2, 4, 5, 7})); // [0->2, 4->5, 7]
        System.out.println(sol.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})); // [0, 2->4, 6, 8->9]
    }
}
