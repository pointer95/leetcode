package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/subsets/
 * @author: pointer
 * @date: Created on 2019/12/24
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        subsetsHelper(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void subsetsHelper(int start, int[] nums,
                               List<Integer> tempList,
                               List<List<Integer>> res) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsetsHelper(i+1, nums, tempList, res);
            tempList.remove(tempList.size()-1);
        }
    }
}
