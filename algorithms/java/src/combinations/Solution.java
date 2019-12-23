package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/combinations/
 * @author: pointer
 * @date: Created on 2019/12/23
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) return res;
        combineHelper(n, k,1, res, new ArrayList<>());
        return res;
    }

    private void combineHelper(int n, int k, int start,
                               List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n-(k-tempList.size())+1; i++) {
            tempList.add(i);
            combineHelper(n, k, i+1, res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
