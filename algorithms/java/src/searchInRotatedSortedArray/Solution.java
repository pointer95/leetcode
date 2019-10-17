package searchInRotatedSortedArray;

/**
 * source: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * date: 2019/10/17
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((nums[0] <= nums[mid] && (target < nums[0] || target > nums[mid]))
                    || (nums[0] > nums[mid] && (target < nums[0] && target > nums[mid]))) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low == high && nums[low] == target ? low : -1;
    }
}
