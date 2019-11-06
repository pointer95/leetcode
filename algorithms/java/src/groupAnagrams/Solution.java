package groupAnagrams;

import java.util.*;

/**
 * source: https://leetcode-cn.com/problems/group-anagrams/
 * date: 2019/11/6
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> res = new HashMap<>();
        for (String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = String.valueOf(carr);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            res.get(key).add(str);
        }
        return new ArrayList(res.values());
    }
}