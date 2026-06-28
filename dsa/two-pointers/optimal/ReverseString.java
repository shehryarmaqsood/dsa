// Time Complexity: O(n) - two pointers each traverse half the array
// Space Complexity: O(1) - in-place swap, no extra array

package two.pointers.optimal;

/**
 * LeetCode 344 - Reverse String
 * Optimal Approach (Two Pointers In-Place):
 * - Left pointer starts at 0, right pointer at end.
 * - Swap characters and move pointers toward each other.
 * - No extra space needed.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left  = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right positions
            char temp  = s[left];
            s[left]    = s[right];
            s[right]   = temp;

            left++;  // move left pointer right
            right--; // move right pointer left
        }
    }

    public static void main(String[] args) {
        ReverseString sol = new ReverseString();
        char[] s1 = {'h','e','l','l','o'};
        sol.reverseString(s1);
        System.out.println(new String(s1)); // Expected: olleh

        char[] s2 = {'H','a','n','n','a','h'};
        sol.reverseString(s2);
        System.out.println(new String(s2)); // Expected: hannaH
    }
}
