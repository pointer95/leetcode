package slidingWindowMaximum;

import java.util.ArrayDeque;

/**
 * source: https://leetcode-cn.com/problems/sliding-window-maximum/
 * date: 2019-08-09
 */
class Solution {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 2) return nums;
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peek() >= k) {
                deque.poll();
            }
            if (i + 1 >= k) {
                result[i+1-k] = nums[deque.peek()];
            }
        }
        return result;
    }
}
