package searchInRotatedSortedArray2;

/**
 * source: https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @author: pointer
 * @date: Created on 2019/12/30
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[low]) {
                low++;
                continue;
            }
            if ((nums[0] < nums[mid] && (target < nums[0] || target > nums[mid]))
                    || (nums[0] > nums[mid] && (target < nums[0] && target > nums[mid]))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}