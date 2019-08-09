package la15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/3sum/
 * date: 2019-08-02
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;
            int first = i + 1, last = nums.length - 1;
            while (first < last) {
                int result = nums[i] + nums[first] + nums[last];
                if (result == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[first], nums[last])));
                }
                if (result <= 0) {
                    while (first < last && nums[first] == nums[++first]);
                } else {
                    while (first < last && nums[last] == nums[--last]);
                }
            }
        }
        return ans;
    }
}
