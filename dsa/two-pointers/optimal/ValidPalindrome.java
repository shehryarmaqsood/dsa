// Time Complexity: O(n) - two pointers scan string once
// Space Complexity: O(1) - no extra string created

package two.pointers.optimal;

/**
 * LeetCode 125 - Valid Palindrome
 * Optimal Approach (Two Pointers, No Extra String):
 * - Use left and right pointers; skip non-alphanumeric characters.
 * - Compare characters at both ends moving inward.
 * - Avoids creating a cleaned copy of the string.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left  = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // mismatch found
            }

            left++;
            right--;
        }
        return true; // all characters matched
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true
        System.out.println(sol.isPalindrome("race a car"));                      // Expected: false
        System.out.println(sol.isPalindrome(" "));                               // Expected: true
    }
}
