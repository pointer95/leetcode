package la120_triangle;

import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/triangle/
 * date: 2019/9/10
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}