package la20_valid_parentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/valid-parentheses/
 * date: 2019-08-04
 */
class Solution {
    private HashMap<Character, Character> hashMap;

    public Solution() {
        this.hashMap = new HashMap<>();
        this.hashMap.put(')', '(');
        this.hashMap.put(']', '[');
        this.hashMap.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.hashMap.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != this.hashMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
