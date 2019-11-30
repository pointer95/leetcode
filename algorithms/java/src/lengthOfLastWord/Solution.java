package lengthOfLastWord;

/**
 * @author: pointer
 * @date: Created on 2019-11-30
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (i == 0) {
                return s.length();
            }
            if (s.charAt(i) == ' ') {
                return s.length() - 1 - i;
            }
        }
        return 0;
    }
}
