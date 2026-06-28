// Time Complexity: O(n * k) - frequency count key is O(k), no sorting needed
// Space Complexity: O(n * k) - storing all words in the HashMap

package hash.tables.optimal;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 * Optimal Approach (Frequency Array as Key):
 * - Instead of sorting each word (O(k log k)), build a 26-char frequency key O(k).
 * - Use this frequency string as HashMap key to group anagrams.
 * - Improves inner loop from O(k log k) to O(k).
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26]; // frequency of each character

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build a unique key from the frequency array e.g. "#1#0#1..."
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append('#').append(count); // '#' separates counts
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        List<List<String>> result = sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> group : result) {
            System.out.println(group);
        }
        // Expected groups: [eat, tea, ate], [tan, nat], [bat]
    }
}
