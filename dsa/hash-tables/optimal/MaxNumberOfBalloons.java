// Time Complexity: O(n) - single pass over text, O(1) for frequency lookup
// Space Complexity: O(1) - fixed 26-letter frequency array

package hash.tables.optimal;

/**
 * LeetCode 1189 - Maximum Number of Balloons
 * Optimal Approach (Frequency Array + HashMap-style):
 * - Use a frequency array of size 26 for all characters.
 * - Divide l and o frequencies by 2 since "balloon" uses each twice.
 * - The answer is the minimum across b, a, l/2, o/2, n.
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26]; // frequency of each letter a-z

        for (char c : text.toCharArray()) {
            freq[c - 'a']++; // increment count for this character
        }

        // "balloon" = b(1) a(1) l(2) o(2) n(1)
        return Math.min(freq['b' - 'a'],
               Math.min(freq['a' - 'a'],
               Math.min(freq['l' - 'a'] / 2,
               Math.min(freq['o' - 'a'] / 2,
                        freq['n' - 'a']))));
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons sol = new MaxNumberOfBalloons();
        System.out.println(sol.maxNumberOfBalloons("nlaebolko"));        // Expected: 1
        System.out.println(sol.maxNumberOfBalloons("loonbalxballpoon")); // Expected: 2
        System.out.println(sol.maxNumberOfBalloons("leetcode"));         // Expected: 0
    }
}
