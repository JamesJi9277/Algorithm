/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        while(head.next != null && head.next.next != null) {
            ListNode second = head.next;
            ListNode third = second.next;
            second.next = third.next;
            head.next = third;
            head = head.next;
            second = second.next;
        }
        head.next = even;
        return odd;
    }
}