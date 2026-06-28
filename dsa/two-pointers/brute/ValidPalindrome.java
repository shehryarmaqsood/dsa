// Time Complexity: O(n) - clean string then compare
// Space Complexity: O(n) - cleaned string stored separately

package two.pointers.brute;

/**
 * LeetCode 125 - Valid Palindrome
 * Brute Force Approach:
 * - Strip all non-alphanumeric characters and lowercase the result.
 * - Compare cleaned string with its reverse.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Keep only alphanumeric characters, convert to lowercase
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String forward  = cleaned.toString();
        String backward = cleaned.reverse().toString();

        return forward.equals(backward); // palindrome check via reversal
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true
        System.out.println(sol.isPalindrome("race a car"));                      // Expected: false
        System.out.println(sol.isPalindrome(" "));                               // Expected: true
    }
}
