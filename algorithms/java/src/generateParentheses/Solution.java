package generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/generate-parentheses/
 * date; 2019/10/4
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "";
        generateParenthesisHelper(res, n, n, s);
        return res;
    }

    private void generateParenthesisHelper(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            generateParenthesisHelper(res, left-1, right, s+"(");
        }
        if (right > 0 && right > left) {
            generateParenthesisHelper(res, left, right-1, s+")");
        }
    }
}
