package stringToIntegerAtoi;

/**
 * source: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * date: 2019/9/19
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        int res = 0, i = 0;
        boolean sign = true;
        if (str.charAt(0) == '+')
            i++;
        if (str.charAt(0) == '-') {
            sign = false;
            i++;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            int digit = c - '0';
            if (sign) {
                if (res > (Integer.MAX_VALUE - digit) / 10)
                    return Integer.MAX_VALUE;
            } else {
                if (-res < (Integer.MIN_VALUE + digit) / 10)
                    return Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return res * (sign ? 1 : -1);
    }
}