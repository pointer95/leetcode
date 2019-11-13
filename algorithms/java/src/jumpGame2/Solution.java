package jumpGame2;

/**
 * source: https://leetcode-cn.com/problems/jump-game-ii/
 * date: 2019/11/13
 */
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, maxPosition = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                res++;
            }
        }
        return res;
    }
}
