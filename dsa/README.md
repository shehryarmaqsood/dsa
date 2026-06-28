# DSA Assignment — Data Structures & Algorithms

> **Course:** Data Structures & Algorithms (DSA)  
> **Deadline:** June 28, 2026  
> **Language:** Java  
> **Platform:** LeetCode + GitHub

---

## Repository Structure

```
dsa/
├── arrays-strings/      ← Arrays & Strings (5 problems)
│   ├── brute/
│   └── optimal/
├── hash-tables/         ← Hash Tables (5 problems)
│   ├── brute/
│   └── optimal/
├── two-pointers/        ← Two Pointers (3 problems)
│   ├── brute/
│   └── optimal/
├── binary-trees/        ← Binary Trees (7 problems)
│   ├── brute/
│   └── optimal/
├── linked-lists/        ← Linked Lists (3 problems)
│   ├── brute/
│   └── optimal/
└── heaps/               ← Heaps / Priority Queues (3 problems)
    ├── brute/
    └── optimal/
```

---

## Topic Index

| Topic | Problems | README |
|-------|----------|--------|
| [Arrays & Strings](./arrays-strings/README.md) | Find Closest to Zero, Is Subsequence, Summary Ranges, Longest Common Prefix, Best Time to Buy & Sell Stock | [README](./arrays-strings/README.md) |
| [Hash Tables](./hash-tables/README.md) | Contains Duplicate, Two Sum, Max Balloons, Valid Anagram, Group Anagrams | [README](./hash-tables/README.md) |
| [Two Pointers](./two-pointers/README.md) | Reverse String, Valid Palindrome, Container With Most Water | [README](./two-pointers/README.md) |
| [Binary Trees](./binary-trees/README.md) | Invert Tree, Max Depth, Kth Smallest BST, Diameter, Validate BST, Trie, Min Abs Diff | [README](./binary-trees/README.md) |
| [Linked Lists](./linked-lists/README.md) | Remove Duplicates, Linked List Cycle, Merge Two Sorted Lists | [README](./linked-lists/README.md) |
| [Heaps](./heaps/README.md) | Last Stone Weight, Kth Largest Element, Top K Frequent | [README](./heaps/README.md) |

---

## How to Run Any Solution

```bash
# Compile
javac path/to/FileName.java

# Run (use full package path)
java package.name.ClassName

# Example
cd arrays-strings/optimal
javac BestTimeToBuyAndSellStock.java
java arrays.strings.optimal.BestTimeToBuyAndSellStock
```

---

## Approach Summary

Every problem is solved in **two passes**:

1. **Brute Force** (`brute/`) — Establishes correctness. May use nested loops, sorting, or extra space. Comments explain the naive strategy and its Big-O.
2. **Optimal** (`optimal/`) — Improves time/space using the right data structure (HashSet, HashMap, heap, two pointers, DFS with bounds, etc.). Big-O is noted at the top of every file.

---

*All solutions written in Java. Each file contains exactly one public class with a `main()` method demonstrating at least one sample test case.*
