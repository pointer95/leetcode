package la150_evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * date: 2019-08-06
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(val2 + val1);
                }
                if ("-".equals(token)) {
                    stack.push(val2 - val1);
                }
                if ("*".equals(token)) {
                    stack.push(val2 * val1);
                }
                if ("/".equals(token)) {
                    stack.push(val2 / val1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
