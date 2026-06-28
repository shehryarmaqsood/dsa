// Time Complexity: O(n * m) - nested loops for each char of s against t
// Space Complexity: O(1) - no extra space

package arrays.strings.brute;

/**
 * LeetCode 392 - Is Subsequence
 * Brute Force Approach:
 * - For each character in s, search t from start for a match.
 * - Track position in t manually to avoid repeating matches.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0; // pointer for string s

        // Walk through every character of t
        for (int tIndex = 0; tIndex < t.length() && sIndex < s.length(); tIndex++) {
            // If character matches, advance s pointer
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }
        // If all characters of s were matched, it is a subsequence
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();
        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // Expected: true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // Expected: false
    }
}
