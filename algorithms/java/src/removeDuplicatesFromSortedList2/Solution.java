package removeDuplicatesFromSortedList2;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author: pointer
 * @date: Created on 2020/1/2
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h, q = h.next;
        while (q != null) {
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (p.next != q) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return h.next;
    }
}
