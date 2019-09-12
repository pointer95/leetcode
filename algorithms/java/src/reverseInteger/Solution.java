package reverseInteger;

/**
 * source: https://leetcode-cn.com/problems/reverse-integer/
 * date: 2019/9/11
 */
class Solution {
    public int reverse(int x) {
        int res = 0;
        int n;
        while (x != 0) {
            n = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
                return 0;
            res = res * 10 + n;
            x = x / 10;
        }
        return res;
    }
}