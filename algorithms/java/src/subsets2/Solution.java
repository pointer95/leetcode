package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/subsets-ii/
 * @author: pointer
 * @date: Created on 2020/1/6
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        subsetsWithDupHelper(0, nums, res, new ArrayList<>());
        return res;
    }

    private void subsetsWithDupHelper(int start, int[] nums,
                                      List<List<Integer>> res,
                                      List<Integer> tempList) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            subsetsWithDupHelper(i+1, nums, res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
