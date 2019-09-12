package removeElement;

/**
 * remove element
 * source: https://leetcode-cn.com/problems/remove-element/
 * date: 2019-08-01
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
