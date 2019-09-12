package reverseString;

/**
 * source: https://leetcode-cn.com/problems/reverse-string/
 * date: 2019/8/14
 */
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
