package coinChange;

/**
 * source: https://leetcode-cn.com/problems/coin-change/
 * date: 2019/9/5
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return -1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] != amount+1 ? dp[amount] : -1;
    }
}
