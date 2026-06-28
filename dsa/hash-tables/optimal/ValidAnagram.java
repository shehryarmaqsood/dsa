// Time Complexity: O(n) - single pass over both strings
// Space Complexity: O(1) - fixed-size array of 26 letters

package hash.tables.optimal;

/**
 * LeetCode 242 - Valid Anagram
 * Optimal Approach (Frequency Counter):
 * - Use a frequency array of 26 slots (one per lowercase letter).
 * - Increment for each char in s, decrement for each char in t.
 * - If all slots are 0 at the end, the strings are anagrams.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26]; // frequency difference array

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // +1 for s character
            freq[t.charAt(i) - 'a']--; // -1 for t character
        }

        // All zeros means every character matches in count
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println(sol.isAnagram("rat", "car"));         // Expected: false
    }
}
