# Two Pointers

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Reverse String | Easy | [Link](https://leetcode.com/problems/reverse-string/) |
| 2 | Valid Palindrome | Easy | [Link](https://leetcode.com/problems/valid-palindrome/) |
| 3 | Container With Most Water | Medium | [Link](https://leetcode.com/problems/container-with-most-water/) |

## Approach

**Reverse String:** Brute force copies characters into a new array in reverse order then copies back — O(n) space. Optimal uses two pointers at both ends and swaps in place, needing O(1) extra space.

**Valid Palindrome:** Brute force cleans the string (remove non-alphanumeric, lowercase), stores it in a new string, then compares with its reverse — O(n) space. Optimal skips the copy entirely: two pointers start at each end and skip non-alphanumeric characters on the fly, comparing only valid characters — O(1) space.

**Container With Most Water:** Brute force tries every pair of lines at O(n²). Optimal starts with pointers at both ends (maximum width) and always moves the pointer pointing to the shorter line inward. Moving the taller side can never increase area, so this greedy choice is provably correct — O(n).

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Reverse String | O(n) | O(n) | O(n) | O(1) |
| Valid Palindrome | O(n) | O(n) | O(n) | O(1) |
| Container With Most Water | O(n²) | O(1) | O(n) | O(1) |

## How to Run

```bash
cd two-pointers/brute
javac ContainerWithMostWater.java && java two.pointers.brute.ContainerWithMostWater

cd two-pointers/optimal
javac ValidPalindrome.java && java two.pointers.optimal.ValidPalindrome
```
