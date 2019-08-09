package la2_add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0, y = 0, carry = 0, sum = 0;
        ListNode head = new ListNode(0), current = head;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            } else {
                x = 0;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            } else {
                y = 0;
            }

            sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;

            carry = sum / 10;
        }

        if (carry > 0) {
            current.next = new ListNode(carry % 10);
        }

        return head.next;
    }
}