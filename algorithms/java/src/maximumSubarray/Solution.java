package maximumSubarray;

/**
 * source: https://leetcode-cn.com/problems/maximum-subarray/
 * date: 2019/11/22
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
