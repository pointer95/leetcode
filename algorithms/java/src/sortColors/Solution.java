package sortColors;

/**
 * source: https://leetcode-cn.com/problems/sort-colors/
 * @author: pointer
 * @date: Created on 2019-12-22
 */
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                int temp = nums[p1];
                nums[p1++] = nums[p0];
                nums[p0++] = temp;
            } else if (nums[p1] == 2) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2--] = temp;
            } else {
                p1++;
            }
        }
    }
}
