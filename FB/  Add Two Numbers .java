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
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        int carry = 0;
        ListNode runner1 = l1;
        ListNode runner2 = l2;
        while (runner1 != null && runner2 != null) {
            int sum = (runner1.val + runner2.val + carry) % 10;
            carry = (runner1.val + runner2.val + carry) / 10;
            ListNode next = new ListNode(sum);
            runner.next = next;
            runner = next;
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        while (runner1 != null) {
            int sum = (runner1.val + carry) % 10;
            carry = (runner1.val + carry) / 10;
            ListNode next = new ListNode(sum);
            runner.next = next;
            runner = next;
            runner1 = runner1.next;
        }
        while (runner2 != null) {
            int sum = (runner2.val + carry) % 10;
            carry = (runner2.val + carry) / 10;
            ListNode next = new ListNode(sum);
            runner.next = next;
            runner = next;
            runner2 = runner2.next;
        }
        if (carry == 1) {
            ListNode next = new ListNode(1);
            runner.next = next;
            next.next = null;
        }
        return dummy.next;
    }
}