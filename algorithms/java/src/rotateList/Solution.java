package rotateList;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/rotate-list/
 * @author: pointer
 * @date: Created on 2019/12/11
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        int pos = len - k % len;
        if (pos == len) {
            return head;
        }
        current = head;
        ListNode posNode = head;
        while (pos > 0) {
            posNode = current;
            current = current.next;
            pos--;
        }
        ListNode res = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        posNode.next = null;
        return res;
    }
}
