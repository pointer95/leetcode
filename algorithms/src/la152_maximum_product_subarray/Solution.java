package la152_maximum_product_subarray;

/**
 * source: https://leetcode-cn.com/problems/maximum-product-subarray/
 * date: 2019/9/9
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(res, max);
        }
        return res;
    }
}
