package removeDuplicatesFromSortedList;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author: pointer
 * @date: Created on 2019/12/31
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }
}
