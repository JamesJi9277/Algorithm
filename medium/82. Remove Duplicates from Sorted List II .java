/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        while (runner.next != null && runner.next.next != null) {
            if (runner.next.val == runner.next.next.val) {
                int val = runner.next.val;
                while (runner.next != null && runner.next.val == val) {
                    runner.next = runner.next.next;
                }
            } else {
                runner = runner.next;
            }
        }
        return dummy.next;
    }
}