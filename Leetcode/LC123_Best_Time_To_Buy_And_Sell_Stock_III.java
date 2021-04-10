import java.util.Arrays;


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
    /**
     * Version A
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i += 1) {
            int[] A = Arrays.copyOfRange(prices, 0, i);
            int[] B = Arrays.copyOfRange(prices, i, prices.length);
            profit = Math.max(profit, this.maxProfit_Single(A) + this.maxProfit_Single(B));
        }
        return profit;
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
        LC123_Best_Time_To_Buy_And_Sell_Stock_III testCase = new LC123_Best_Time_To_Buy_And_Sell_Stock_III();

        assert testCase.maxProfit(new int[]{}) == 0 : "Edge 0";
        assert testCase.maxProfit(new int[]{1}) == 0 : "Edge 1";

        assert testCase.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}) == 6 : "Example 1, two transactions";
        assert testCase.maxProfit(new int[]{1, 2, 3, 4, 5}) == 4 : "Example 2, one transactions";
        assert testCase.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0 : "Example 3, zero transactions";

        assert testCase.maxProfit(new int[]{1, 11, 1, 2, 3, 2, 3, 4, 3, 4, 5}) == 14 : "Additional 1";
        assert testCase.maxProfit(new int[]{5, 6, 1, 4, 2, 6}) == 7 : "Additional 2";

        System.out.println("All passed");
    }
}

