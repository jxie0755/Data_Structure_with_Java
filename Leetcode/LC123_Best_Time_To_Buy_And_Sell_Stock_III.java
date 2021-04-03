/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * LC123 Best Time to Buy and Sell Stock III
 * Hard
 * <p>
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
class LC123_Best_Time_To_Buy_And_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * Helper function for single transaction max profit
     * Referred from LC121
     */
    private int maxProfit_Single(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i += 1) {
            int current = prices[i];
            min_price = Math.min(min_price, current);
            profit = Math.max(profit, current - min_price);
        }
        return profit;
    }

    public static void main(String[] args) {

    }
}

