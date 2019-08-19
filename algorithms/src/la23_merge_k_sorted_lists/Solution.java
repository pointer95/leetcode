package la23_merge_k_sorted_lists;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * date: 2019-08-02
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i < lists.length - interval; i += interval * 2) {
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists.length != 0 ? lists[0] : null;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return head.next;
    }
}
