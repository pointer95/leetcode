package reverseNodesInKGroup;

import common.ListNode;

/**
 * source: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * date: 2019/10/8
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) return head;
        int temp = 0;
        ListNode tail = head;
        // 定位尾节点
        while (tail != null && temp != k) {
            tail = tail.next;
            temp++;
        }
        // 翻转链表
        if (temp == k) {
            tail = reverseKGroup(tail, k);
            while (temp > 0) {
                ListNode cur = head.next;
                head.next = tail;
                tail = head;
                head = cur;
                temp--;
            }
            head = tail;
        }
        return head;
    }
}
