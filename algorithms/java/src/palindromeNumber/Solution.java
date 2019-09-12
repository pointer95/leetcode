package palindromeNumber;

/**
 * source: https://leetcode-cn.com/problems/palindrome-number/
 * date: 2019/9/12
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0, t = x;
        while (t != 0) {
            y = y * 10 + t % 10;
            t = t / 10;
        }
        return y == x;
    }
}