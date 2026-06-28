// Time Complexity: O(n log n + m) - sort O(n log n), then compare first and last O(m)
// Space Complexity: O(1) - only two string references compared

package arrays.strings.optimal;

import java.util.Arrays;

/**
 * LeetCode 14 - Longest Common Prefix
 * Optimal Approach (Sort + Compare Extremes):
 * - Sort the array lexicographically. The most different strings will be first and last.
 * - The common prefix of the entire array equals the common prefix of first and last strings only.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs); // lexicographic sort

        String first = strs[0];               // lexicographically smallest
        String last  = strs[strs.length - 1]; // lexicographically largest
        int i = 0;

        // Compare characters of first and last strings
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i); // common prefix length is i
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"})); // "fl"
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));    // ""
    }
}
