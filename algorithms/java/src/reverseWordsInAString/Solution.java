package reverseWordsInAString;

/**
 * source: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * date: 2019/8/15
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        // \s+ is a regular expression for one or more spaces.
        String[] strArr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i > 0; i--) {
            sb.append(strArr[i]).append(" ");
        }
        sb.append(strArr[0]);
        return sb.toString();
    }
}
