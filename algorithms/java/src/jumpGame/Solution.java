package jumpGame;

/**
 * source: https://leetcode-cn.com/problems/jump-game/
 * date: 2019/11/24
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxPosition = 0, i;
        for (i = 0; i < nums.length - 1; i++) {
            if (i > maxPosition) {
                return false;
            }
            maxPosition = Math.max(maxPosition, nums[i] + i);
        }
        return maxPosition >= i;
    }
}
