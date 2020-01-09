package decodeWays;

import java.util.Arrays;

/**
 * source: https://leetcode-cn.com/problems/decode-ways/
 * @author: pointer
 * @date: Created on 2020/1/9
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return check(s.charAt(0));

        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);

        dp[0] = check(s.charAt(0));
        dp[1] = check(s.charAt(0)) * check(s.charAt(1))
                + check(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) break;
            if (check(s.charAt(i)) == 1) {
                dp[i] = dp[i-1];
            }
            if (check(s.charAt(i-1), s.charAt(i)) == 1) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()-1];
    }

    private int check(char c) {
        return (!isDigit(c) || c == '0') ? 0 : 1;
    }

    private int check(char c1, char c2) {
        return (c1 == '1' || (c1 == '2' && c2 <= '6')) ? 1 : 0;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private int numDecodingsHelper(int start, String s) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int res1 = numDecodingsHelper(start+1, s);
        int res2 = 0;
        if (start < s.length() - 1) {
            int decade = (s.charAt(start) - '0') * 10;
            int unit = s.charAt(start+1) - '0';
            if (decade + unit <= 26) {
                res2 = numDecodingsHelper(start+2, s);
            }
        }
        return res1 + res2;
    }
}
