package removeNthNodeFromEndOfList;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * date: 2019/10/3
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n > 0) {
            end = end.next;
            n--;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return pre.next;
    }
}
