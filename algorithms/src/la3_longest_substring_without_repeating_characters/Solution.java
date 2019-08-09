package la3_longest_substring_without_repeating_characters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int flag = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > flag) {
                flag = map.get(s.charAt(i));
            }
            if (i - flag > maxLen) {
                maxLen = i - flag;
            }
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
