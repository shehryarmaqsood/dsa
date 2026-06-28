# Arrays & Strings

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|---------------|
| 1 | Find Closest Number to Zero | Easy | [Link](https://leetcode.com/problems/find-closest-number-to-zero/) |
| 2 | Is Subsequence | Easy | [Link](https://leetcode.com/problems/is-subsequence/) |
| 3 | Summary Ranges | Easy | [Link](https://leetcode.com/problems/summary-ranges/) |
| 4 | Longest Common Prefix | Easy | [Link](https://leetcode.com/problems/longest-common-prefix/) |
| 5 | Best Time to Buy and Sell Stock | Easy | [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |

## Approach

**Find Closest Number to Zero:** Brute force does a linear scan tracking the minimum absolute value with a tie-breaking condition. Optimal collapses the two conditions into a single clean expression in one pass.

**Is Subsequence:** Brute force uses nested loops checking each character of `s` against all of `t`. Optimal uses two independent pointers — one for `s` and one for `t` — advancing each separately, reducing time from O(n*m) to O(n+m).

**Summary Ranges:** Brute force checks every pair of indices to find range boundaries. Optimal uses a single `start` pointer and a linear scan, building ranges in one pass at O(n).

**Longest Common Prefix:** Brute force repeatedly trims the prefix until every string starts with it. Optimal sorts the array lexicographically and only compares the first and last strings — they are the most different, so their common prefix is the answer for the whole array.

**Best Time to Buy and Sell Stock:** Brute force tries every (buy, sell) pair at O(n²). Optimal tracks a running minimum price and computes max profit in a single O(n) pass.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---------|-----------|-------------|--------------|---------------|
| Find Closest Number to Zero | O(n) | O(1) | O(n) | O(1) |
| Is Subsequence | O(n*m) | O(1) | O(n+m) | O(1) |
| Summary Ranges | O(n) | O(n) | O(n) | O(n) |
| Longest Common Prefix | O(n*m) | O(m) | O(n log n) | O(1) |
| Best Time to Buy & Sell Stock | O(n²) | O(1) | O(n) | O(1) |

## How to Run

```bash
cd arrays-strings/brute
javac FindClosestNumberToZero.java && java arrays.strings.brute.FindClosestNumberToZero

cd arrays-strings/optimal
javac BestTimeToBuyAndSellStock.java && java arrays.strings.optimal.BestTimeToBuyAndSellStock
```
