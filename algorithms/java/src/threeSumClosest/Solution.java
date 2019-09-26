package threeSumClosest;

import java.util.Arrays;

/**
 * source: https://leetcode-cn.com/problems/3sum-closest/
 * date: 2019/9/26
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int first = i + 1, last = nums.length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    first++;
                } else {
                    last--;
                }
            }
        }
        return res;
    }
}
