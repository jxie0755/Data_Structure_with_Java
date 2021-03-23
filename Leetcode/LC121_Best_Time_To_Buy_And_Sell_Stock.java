/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * LC121 Best Time to Buy and Sell Stock
 * Easy
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 */
class LC121_Best_Time_To_Buy_And_Sell_Stock {
    /**
     * Version STD2
     */
    public int maxProfit(int[] prices) {
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
        LC121_Best_Time_To_Buy_And_Sell_Stock testCase = new LC121_Best_Time_To_Buy_And_Sell_Stock();

        assert testCase.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5 : "Example 1";
        // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5

        assert testCase.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0 : "Example 2";
        // Prices keep dropping, max profit = 0

        assert testCase.maxProfit(new int[]{100, 5, 25, 1, 20}) == 20 : "Additional 1";
        // Buy on day 1 (price = 5) and sell on day 2 (price = 25), profit = 25-5 = 20

        System.out.println("All passed");
    }
}

