package uniqueBinarySearchTrees;

/**
 * source: https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author: pointer
 * @date: Created on 2020/1/20
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
