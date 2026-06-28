// Time Complexity: O(n) - iterate through half the array
// Space Complexity: O(n) - extra array to store reversed chars

package two.pointers.brute;

/**
 * LeetCode 344 - Reverse String
 * Brute Force Approach:
 * - Copy characters into a new array in reverse order.
 * - Copy back into original array.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char[] temp = new char[s.length]; // extra space for reversed copy

        for (int i = 0; i < s.length; i++) {
            temp[s.length - 1 - i] = s[i]; // fill temp in reverse
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = temp[i]; // copy back to original
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
