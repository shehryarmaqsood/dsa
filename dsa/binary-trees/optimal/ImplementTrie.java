// Time Complexity: O(L) per insert/search/startsWith where L = word length
// Space Complexity: O(n * L) total for all nodes (each char becomes a TrieNode)

package binary.trees.optimal;

/**
 * LeetCode 208 - Implement Trie (Prefix Tree)
 * Optimal Approach (TrieNode with children array):
 * - Each node stores 26 child pointers (one per letter) and an end-of-word flag.
 * - insert/search/startsWith all run in O(L) where L = word length.
 * - Much faster than linear scan over word list.
 */
public class ImplementTrie {

    // Each TrieNode represents a character position
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // one slot per lowercase letter
        boolean isEnd = false;                  // marks end of a complete word
    }

    private final TrieNode root;

    public ImplementTrie() {
        root = new TrieNode(); // empty root node
    }

    // Insert a word character by character
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(); // create node if missing
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true; // mark end of word
    }

    // Returns true if word exists in trie
    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd; // must reach end AND be marked as complete word
    }

    // Returns true if any inserted word starts with prefix
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null; // just need to reach the end of prefix
    }

    // Helper: walk the trie along the string; return null if path breaks
    private TrieNode traverse(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return null; // path doesn't exist
            curr = curr.children[idx];
        }
        return curr;
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
