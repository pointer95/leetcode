package la32_longest_valid_parentheses;

import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * date: 2019-08-06
 */
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }
}
