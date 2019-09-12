package firstMissingPositive;

/**
 * source: https://leetcode-cn.com/problems/first-missing-positive/
 * date: 2019-08-02
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            // 将 num 移动到 index + 1 的位置
            while (num > 0 && num < nums.length && nums[num-1] != num) {
                int temp = nums[i];
                nums[i] = nums[num-1];
                nums[num-1] = temp;
                num = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}