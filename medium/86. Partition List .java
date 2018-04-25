/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        while (head != null) {
            if (head.val < x) {
                runner1.next = head;
                head = head.next;
                runner1 = runner1.next;
            } else {
                runner2.next = head;
                head = head.next;
                runner2 = runner2.next;
            }
        }
        runner2.next = null;
        runner1.next = head2.next;
        return head1.next;
    }
}