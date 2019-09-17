package longestPalindromicSubstring;

/**
 * source: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * date: 2019/9/17
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddlen = longestPalindromeHelper(s, i, i);
            int evenlen = longestPalindromeHelper(s, i, i+1);
            int len = Math.max(oddlen, evenlen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int longestPalindromeHelper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}