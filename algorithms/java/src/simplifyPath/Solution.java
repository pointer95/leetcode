package simplifyPath;

import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/simplify-path/
 * @author: pointer
 * @date: Created on 2019/12/18
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (String str : strings) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        String res = sb.toString();
        return res.equals("") ? "/" : res;
    }
}