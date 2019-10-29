package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/permutations/
 * date: 2019/10/29
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int[] visit = new int[nums.length];
        permuteHelper(nums, visit, res, new ArrayList<>());
        return res;
    }

    private void permuteHelper(int[] nums, int[] visit,
                               List<List<Integer>> res,
                               ArrayList<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1) continue;
            tempList.add(nums[i]);
            visit[i] = 1;
            permuteHelper(nums, visit, res, tempList);
            tempList.remove(tempList.size() - 1);
            visit[i] = 0;
        }
    }
}
