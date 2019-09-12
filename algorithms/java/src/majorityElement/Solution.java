package majorityElement;

import java.util.Arrays;

/**
 * source: https://leetcode-cn.com/problems/majority-element/
 * date: 2019-08-02
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
