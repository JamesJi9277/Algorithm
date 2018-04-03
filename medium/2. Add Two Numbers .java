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
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode runner = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode temp = new ListNode(digit);
            runner.next = temp;
            runner = runner.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode temp = new ListNode(digit);
            runner.next = temp;
            runner = runner.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int digit = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode temp = new ListNode(digit);
            runner.next = temp;
            runner = runner.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            runner.next = temp;
        }
        return head.next;
    }
}