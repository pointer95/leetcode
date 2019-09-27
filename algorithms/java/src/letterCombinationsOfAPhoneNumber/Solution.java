package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * source: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * date: 2019/9/27
 */
class Solution {
    private static Map<Character, String> map;
    private static List<String> res;

    Solution() {
        res =  new ArrayList<String>();
        map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) return res;
        letterCombinationsHelper(digits, 0, "");
        return res;
    }

    private void letterCombinationsHelper(String digits, int pos, String s) {
        if (pos < digits.length()) {
            char digit = digits.charAt(pos);
            String str = map.get(digit);
            for (int i = 0; i < str.length(); i++) {
                letterCombinationsHelper(digits, pos+1, s + str.charAt(i));
            }
        } else {
            res.add(s);
        }
    }
}
