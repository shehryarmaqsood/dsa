// Time Complexity: O(n log n) - sorting both strings
// Space Complexity: O(n) - char arrays for sorting

package hash.tables.brute;

import java.util.Arrays;

/**
 * LeetCode 242 - Valid Anagram
 * Brute Force Approach:
 * - Sort both strings character by character.
 * - If the sorted versions are equal, they are anagrams.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // different lengths can't be anagrams

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr); // sort both character arrays
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr); // anagram iff sorted forms are equal
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println(sol.isAnagram("rat", "car"));         // Expected: false
    }
}
