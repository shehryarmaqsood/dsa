// Time Complexity: O(n^2) - check every pair of buy/sell days
// Space Complexity: O(1) - only tracking max profit

package arrays.strings.brute;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock
 * Brute Force Approach:
 * - Try every possible (buy day, sell day) pair where buy < sell.
 * - Track the maximum profit across all pairs.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0; // minimum possible profit is 0 (don't trade)

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i]; // sell on day j, buy on day i
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Expected: 5
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));    // Expected: 0
    }
}
