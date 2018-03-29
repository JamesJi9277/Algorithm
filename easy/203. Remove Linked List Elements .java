/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        while (runner.next != null) {
            if (runner.next.val == val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        return dummy.next;
    }
}