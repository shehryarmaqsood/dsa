// Time Complexity: O(n) - single pass through prices
// Space Complexity: O(1) - only two variables

package arrays.strings.optimal;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock
 * Optimal Approach (One Pass / Running Minimum):
 * - Track the minimum price seen so far as the best buy day.
 * - At each day, compute profit if we sell today and update max profit.
 * - No nested loops needed.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice  = Integer.MAX_VALUE; // best buy price seen so far
        int maxProfit = 0;                 // best profit seen so far

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;          // found a cheaper buying opportunity
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // selling today gives better profit
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
