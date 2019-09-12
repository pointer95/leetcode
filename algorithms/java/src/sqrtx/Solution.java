package sqrtx;

/**
 * source: https://leetcode-cn.com/problems/sqrtx/
 * date: 2019-08-12
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x / 2;
        while (left < right) {
            long middle = (left + right + 1) >> 1;
            long square = middle * middle;
            if (square > x) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        return (int) left;
    }
}
