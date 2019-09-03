package la10_regular_expression_matching;

/**
 * aource: https://leetcode-cn.com/problems/regular-expression-matching/
 * date: 2019/9/3
 */
class Solution {
    private boolean matched = false;
    private char[] pattern;
    private int plen;

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        int slen = str.length;
        pattern = p.toCharArray();
        plen = pattern.length;
        rmatch(0, 0, str, slen);
        return matched;
    }

    private void rmatch(int si, int pj, char[] str, int slen) {
        if (matched || si > slen || pj > plen) return;
        if (pj == plen) {
            matched = si == slen;
            return;
        }
        if (pj+1 == plen || pattern[pj+1] != '*') {
            if (si == slen || (pattern[pj] != '.' && str[si] != pattern[pj])) {
                return;
            }
            rmatch(si+1, pj+1, str, slen);
            return;
        }
        int i = -1;
        while (si + i < slen
                && (i < 0 || pattern[pj] == '.' || pattern[pj] == str[si+i])) {
            rmatch(si+i+1, pj+2, str, slen);
            if (matched) return;
            i++;
        }
    }
}
