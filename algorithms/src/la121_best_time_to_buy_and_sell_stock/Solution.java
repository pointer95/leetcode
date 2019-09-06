package la121_best_time_to_buy_and_sell_stock;

/**
 * source: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * date: 2019/9/6
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int d = prices.length;
        int[][] dp = new int[d][2];
        for (int i = 0; i < d; i++) {
            if (i < 1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[d-1][0];
    }
}
