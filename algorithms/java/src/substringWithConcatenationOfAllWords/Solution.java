package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * source: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * date: 2019/11/11
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String str : words) {
            wordsMap.put(str, wordsMap.getOrDefault(str, 0)+1);
        }

        List<Integer> res = new ArrayList<>();
        int oneWordsSize = words[0].length();
        int allWordsSize = words.length * oneWordsSize;
        for (int i = 0; i < s.length() - allWordsSize + 1; i++) {
            String tempStr = s.substring(i, i + allWordsSize);
            Map<String, Integer> tempMap = new HashMap<>(wordsMap);
            for (int j = 0; j < tempStr.length() - oneWordsSize + 1; j+=oneWordsSize) {
                String key = tempStr.substring(j, j+oneWordsSize);
                if (!tempMap.containsKey(key)) {
                    break;
                }
                int val = tempMap.get(key) - 1;
                if (val == 0) {
                    tempMap.remove(key);
                } else {
                    tempMap.put(key, val);
                }
            }
            if (tempMap.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }
}
