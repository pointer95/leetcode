package powxN;

/**
 * source: https://leetcode-cn.com/problems/powx-n/
 * date: 2019/11/7
 */
class Solution {

    /**
     * 如果 n 为奇数， x^n = (x^(n/2))^2 * x
     * 如果 n 为奇数， x^n = (x^(n/2))^2
     * 例如：
     * 3^9 = (3^4)^2 * 3
     * 3^4 = (3^2)^2
     * 3^2 = (3^1)^2
     * 3^1 = 3
     */
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return myPowHelper(x, N);
    }

    private double myPowHelper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = myPowHelper(x, n/2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}
