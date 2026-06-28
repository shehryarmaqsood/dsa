// Time Complexity: O(n) - count characters in one pass
// Space Complexity: O(1) - fixed size count variables

package hash.tables.brute;

/**
 * LeetCode 1189 - Maximum Number of Balloons
 * Brute Force Approach:
 * - Manually count occurrences of b, a, l, o, n in the text.
 * - Use floor division (l and o appear twice in "balloon") to find max instances.
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int countB = 0, countA = 0, countL = 0, countO = 0, countN = 0;

        // Count relevant characters
        for (char c : text.toCharArray()) {
            if (c == 'b') countB++;
            else if (c == 'a') countA++;
            else if (c == 'l') countL++;
            else if (c == 'o') countO++;
            else if (c == 'n') countN++;
        }

        // "balloon" needs: 1b, 1a, 2l, 2o, 1n
        // So divide l and o counts by 2
        return Math.min(countB, Math.min(countA, Math.min(countL / 2, Math.min(countO / 2, countN))));
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons sol = new MaxNumberOfBalloons();
        System.out.println(sol.maxNumberOfBalloons("nlaebolko"));      // Expected: 1
        System.out.println(sol.maxNumberOfBalloons("loonbalxballpoon")); // Expected: 2
        System.out.println(sol.maxNumberOfBalloons("leetcode"));        // Expected: 0
    }
}
