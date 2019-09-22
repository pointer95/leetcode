package containerWithMostWater;

/**
 * source: https://leetcode-cn.com/problems/container-with-most-water/
 * date: 2019/9/22
 */
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}