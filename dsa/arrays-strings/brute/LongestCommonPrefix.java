// Time Complexity: O(n * m) - compare all pairs character by character
// Space Complexity: O(m) - result prefix string (m = length of shortest string)

package arrays.strings.brute;

/**
 * LeetCode 14 - Longest Common Prefix
 * Brute Force Approach:
 * - Take the first string as the initial prefix.
 * - Reduce the prefix until every string starts with it.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // assume the whole first string is the prefix

        for (int i = 1; i < strs.length; i++) {
            // Keep trimming prefix from the end until current string starts with it
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // no common prefix at all
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"})); // "fl"
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));    // ""
    }
}
