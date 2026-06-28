// Time Complexity: O(n + m) - two pointers advance independently
// Space Complexity: O(1) - no extra space

package arrays.strings.optimal;

/**
 * LeetCode 392 - Is Subsequence
 * Optimal Approach (Two Pointers):
 * - Use two independent pointers, one for s and one for t.
 * - Advance s-pointer only on a match; always advance t-pointer.
 * - Eliminates the need for nested loops.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // match found, move s pointer forward
            }
            j++; // always advance t pointer
        }

        // All characters of s matched if i reached end of s
        return i == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();
        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // Expected: true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // Expected: false
    }
}
