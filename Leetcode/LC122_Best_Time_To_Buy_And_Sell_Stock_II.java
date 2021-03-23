/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * LC122 Best time to buy and sell stock II
 * Easy
 * <p>
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
class LC122_Best_Time_To_Buy_And_Sell_Stock_II {

    /**
     * Version A
     */
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i += 1) {
            int prev = prices[i - 1];
            int cur = prices[i];
            if (prev < cur) {
                profit += cur - prev;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        LC122_Best_Time_To_Buy_And_Sell_Stock_II testCase = new LC122_Best_Time_To_Buy_And_Sell_Stock_II();

        assert testCase.maxProfit(new int[]{0}) == 0 : "Edge 0";
        assert testCase.maxProfit(new int[]{1}) == 0 : "Edge 1";
        assert testCase.maxProfit(new int[]{1, 1, 1}) == 0 : "Edge 2";

        assert testCase.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 7 : "Example 1";
        // Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        // Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

        assert testCase.maxProfit(new int[]{1, 2, 3, 4, 5}) == 4 : "Example 2";
        // Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5 - 1 = 4.
        // Note that you cannot buy on day 1, buy on day 2 and sell them later
        // as you are engaging multiple transactions at the same time.You must sell before buying again.

        assert testCase.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0 : "Example 3";
        // In this case, no transaction is done, i.e.max profit = 0.

        assert testCase.maxProfit(new int[]{1, 2, 2, 2, 3, 3, 2, 2}) == 2 : "Additional 1";
        // flat peak

        assert testCase.maxProfit(new int[]{2, 1, 4}) == 3 : "Additional 2";

        System.out.println("All passed");
    }
}

