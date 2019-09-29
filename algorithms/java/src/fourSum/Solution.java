package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/4sum/
 * date: 2019/9/29
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int first = j + 1, last = nums.length - 1;
                while (first < last) {
                    int result = nums[i] + nums[j]+ nums[first] + nums[last];
                    if (result == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[first], nums[last])));
                    }
                    if (result <= target) {
                        while (first < last && nums[first] == nums[++first]);
                    } else {
                        while (first < last && nums[last] == nums[--last]);
                    }
                }
            }
        }
        return res;
    }
}
