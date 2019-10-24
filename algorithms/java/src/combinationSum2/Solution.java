package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/combination-sum-ii/
 * date: 2019/10/24
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combinationSum2Helper(int[] candidates, int target,
                                      int start, ArrayList<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}