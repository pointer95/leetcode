package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/combination-sum/
 * date: 2019/10/23
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combinationSumHelper(int[] candidates, int target,
                                      int start, ArrayList<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
