package partitionList;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/partition-list/
 * @author: pointer
 * @date: Created on 2020/1/3
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(0),
                qHead = new ListNode(0),
                p = pHead, q = qHead;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = qHead.next;
        return pHead.next;
    }
}
