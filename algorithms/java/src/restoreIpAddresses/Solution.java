package restoreIpAddresses;

/**
 * @author: pointer
 * @date: Created on 2020-01-15
 */

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/restore-ip-addresses/
 * @author: pointer
 * @date: Created on 2020/1/15
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        restoreIpAddressesHelper(s, 0, 4, "", res);
        return res;
    }

    private void restoreIpAddressesHelper(String s, int start, int flag,
                                          String tempStr, List<String> res) {
        if (flag == 0 && start == s.length()) {
            res.add(tempStr.substring(0, tempStr.length()-1));
            return;
        }
        if (flag < 0) return;
        for (int i = start; i < start+3 && i < s.length(); i++) {
            if (i == start && s.charAt(i) == '0') {
                restoreIpAddressesHelper(s, i+1, flag-1,
                        tempStr + "0.", res);
                break;
            }
            if (Integer.parseInt(s.substring(start, i+1)) <= 255) {
                restoreIpAddressesHelper(s, i+1, flag-1,
                        tempStr + s.substring(start, i+1) + ".", res);
            }
        }
    }
}
