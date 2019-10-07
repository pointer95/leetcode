package swapNodesInPairs;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * date: 2019/10/7
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
