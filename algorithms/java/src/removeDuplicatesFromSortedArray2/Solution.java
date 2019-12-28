package removeDuplicatesFromSortedArray2;

/**
 * source: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author: pointer
 * @date: Created on 2019-12-28
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int pos = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[pos-1]) {
                nums[++pos] = nums[i];
            }
        }
        return pos + 1;
    }
}
