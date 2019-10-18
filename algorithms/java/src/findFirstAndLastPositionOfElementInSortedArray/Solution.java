package findFirstAndLastPositionOfElementInSortedArray;

/**
 * source: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * date: 2019/10/18
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int lowIndex = binarySearch(nums, target, true);
        if (lowIndex == nums.length || nums[lowIndex] != target) {
            return res;
        }
        res[0] = lowIndex;
        res[1] = binarySearch(nums, target, false) - 1;
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean isLow) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (isLow && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
