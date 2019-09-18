package zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/zigzag-conversion/
 * date: 2019/9/18
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int curRow = 0;
        boolean change = false;
        List<StringBuilder> lists = new ArrayList<StringBuilder>(numRows);
        for (int i = 0; i < numRows; i++) {
            lists.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            lists.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                change = !change;
            }
            curRow += change ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : lists) {
            sb.append(str);
        }
        return sb.toString();
    }
}
