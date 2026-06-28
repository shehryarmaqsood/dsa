# Hash Tables

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Contains Duplicate | Easy | [Link](https://leetcode.com/problems/contains-duplicate/) |
| 2 | Two Sum | Easy | [Link](https://leetcode.com/problems/two-sum/) |
| 3 | Maximum Number of Balloons | Easy | [Link](https://leetcode.com/problems/maximum-number-of-balloons/) |
| 4 | Valid Anagram | Easy | [Link](https://leetcode.com/problems/valid-anagram/) |
| 5 | Group Anagrams | Medium | [Link](https://leetcode.com/problems/group-anagrams/) |

## Approach

**Contains Duplicate:** Brute force sorts the array so duplicates become adjacent, then scans for equal neighbors — O(n log n). Optimal inserts each element into a HashSet and returns true immediately on a collision — O(n) time, O(n) space.

**Two Sum:** Brute force tries every pair (i, j) at O(n²). Optimal uses a HashMap to store each number's index; for every element, it checks whether its complement (target - num) already exists in the map, completing in a single O(n) pass.

**Maximum Number of Balloons:** Brute force counts b, a, l, o, n manually with individual counters. Optimal uses a 26-slot frequency array, then applies floor division (l and o appear twice in "balloon") and a single min across the five required characters.

**Valid Anagram:** Brute force sorts both strings and compares — O(n log n). Optimal uses a single 26-slot frequency array, incrementing for `s` and decrementing for `t`; if all slots are zero at the end, the strings are anagrams — O(n).

**Group Anagrams:** Brute force sorts each word as a key (O(n · k log k)). Optimal builds a frequency-count string key in O(k) per word using a 26-char array, avoiding sorting entirely.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Contains Duplicate | O(n log n) | O(1) | O(n) | O(n) |
| Two Sum | O(n²) | O(1) | O(n) | O(n) |
| Maximum Number of Balloons | O(n) | O(1) | O(n) | O(1) |
| Valid Anagram | O(n log n) | O(n) | O(n) | O(1) |
| Group Anagrams | O(n · k log k) | O(n·k) | O(n·k) | O(n·k) |

## How to Run

```bash
cd hash-tables/brute
javac TwoSum.java && java hash.tables.brute.TwoSum

cd hash-tables/optimal
javac GroupAnagrams.java && java hash.tables.optimal.GroupAnagrams
```
