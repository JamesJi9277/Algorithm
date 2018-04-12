/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        while (runner.next != null && runner.next.next != null) {
            ListNode first = runner.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            runner.next = second;
            runner = first;
        }
        return dummy.next;
    }
}