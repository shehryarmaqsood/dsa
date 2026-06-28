// Time Complexity: O(n^2 * k) - compare every pair, each comparison O(k)
// Space Complexity: O(n * k) - storing grouped strings

package hash.tables.brute;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 * Brute Force Approach:
 * - For each word, sort it and use the sorted form as a group key.
 * - Group original words by their sorted key. O(n * k log k).
 * (True brute would compare every pair O(n^2*k); this common variant is shown.)
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);                  // sort chars to get the canonical key
            String key = new String(chars);

            // Add word to its anagram group
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
