package trappingRainWater;

/**
 * source: https://leetcode-cn.com/problems/trapping-rain-water/
 * date: 2019/10/25
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            if (minHeight > height[i]) {
                sum += minHeight - height[i];
            }
        }
        return sum;
    }
}
