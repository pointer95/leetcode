package divideTwoIntegers;

/**
 * source: https://leetcode-cn.com/problems/divide-two-integers/
 * date; 2019/10/11
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend ^ divisor) < 0;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                res += 1 << i;
                dvd -= dvs << i;
            }
        }
        return sign ? -res : res;
    }
}
