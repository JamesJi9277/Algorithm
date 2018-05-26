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
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode head = add(head1, head2);
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private ListNode add(ListNode head1, ListNode head2) {
        int carry = 0;
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;

        while (head1 != null && head2 != null) {
            int sum = (head1.val + head2.val + carry) % 10;
            carry = (head1.val + head2.val + carry) / 10;
            ListNode temp = new ListNode(sum);
            runner.next = temp;
            runner = runner.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = (head1.val + carry) % 10;
            carry = (head1.val + carry) / 10;
            ListNode temp = new ListNode(sum);
            runner.next = temp;
            runner = runner.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = (head2.val + carry) % 10;
            carry = (head2.val + carry) / 10;
            ListNode temp = new ListNode(sum);
            runner.next = temp;
            runner = runner.next;
            head2 = head2.next;
        }
        if (carry == 1) {
            runner.next = new ListNode(1);
        }
        return dummy.next;
    }
}