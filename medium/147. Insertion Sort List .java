/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        // 相当于是每次去遍历dummy开始的这个linkedlist
        while (head != null) {
            ListNode temp = dummy;
            while (temp.next != null && temp.next.val < head.val) {
                temp = temp.next;
            }
            ListNode next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return dummy.next;
    }
}