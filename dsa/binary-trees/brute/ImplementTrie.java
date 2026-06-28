// Time Complexity: O(n * L) insert/search where L = word length, n = number of words
// Space Complexity: O(n * L) - storing all words in a list

package binary.trees.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 208 - Implement Trie (Prefix Tree)
 * Brute Force Approach:
 * - Store all inserted words in a list.
 * - search() checks if list contains the word.
 * - startsWith() checks if any word starts with the given prefix.
 */
public class ImplementTrie {

    private List<String> words;

    public ImplementTrie() {
        words = new ArrayList<>();
    }

    // Insert word into the trie (list)
    public void insert(String word) {
        words.add(word);
    }

    // Returns true if word was previously inserted
    public boolean search(String word) {
        return words.contains(word);
    }

    // Returns true if any inserted word starts with prefix
    public boolean startsWith(String prefix) {
        for (String w : words) {
            if (w.startsWith(prefix)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Expected: true
        System.out.println(trie.search("app"));     // Expected: false
        System.out.println(trie.startsWith("app")); // Expected: true
        trie.insert("app");
        System.out.println(trie.search("app"));     // Expected: true
    }
}
