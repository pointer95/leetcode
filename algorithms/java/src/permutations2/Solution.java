package permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/permutations-ii/
 * date: 2019/10/31
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int[] visit = new int[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(nums, visit, res, new ArrayList<>());
        return res;
    }

    private void permuteUniqueHelper(int[] nums, int[] visit,
                               List<List<Integer>> res,
                               ArrayList<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && visit[i-1] ==1
                    && nums[i] == nums[i-1])
                    || (visit[i] == 1)) {
                continue;
            }
            tempList.add(nums[i]);
            visit[i] = 1;
            permuteUniqueHelper(nums, visit, res, tempList);
            tempList.remove(tempList.size() - 1);
            visit[i] = 0;
        }
    }
}
