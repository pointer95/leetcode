package reverseLinkedList2;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author: pointer
 * @date: Created on 2020-01-10
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return h.next;
    }
}
