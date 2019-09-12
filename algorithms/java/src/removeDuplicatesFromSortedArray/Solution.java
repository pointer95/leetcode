package removeDuplicatesFromSortedArray;

/**
 * remove duplicates from sorted array
 * source: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * date: 2019-08-01
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j ++) {
            if (nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
