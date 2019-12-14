package plusOne;

/**
 * source: https://leetcode-cn.com/problems/plus-one/
 * @author: pointer
 * @date: Created on 2019-12-14
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        while (n >= 1) {
            if (digits[n-1] == 9) {
                if (n == 1) {
                    int[] tmpArray = new int[digits.length+1];
                    tmpArray[0] = 1;
                    return tmpArray;
                } else {
                    digits[n - 1] = 0;
                }
            } else {
                digits[n-1] += 1;
                break;
            }
            n--;
        }
        return digits;
    }
}
