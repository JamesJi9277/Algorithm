/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        k = k % length;
        ListNode tail = findKth(head, length - k);
        if (tail.next == null) {
            return head;
        }
        ListNode next = tail.next;
        tail.next = null;
        ListNode runner = next;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = head;
        return next;
    }
    private ListNode findKth(ListNode head, int k) {
        ListNode runner = head;
        while (--k > 0) {
            runner = runner.next;
        }
        return runner;
    }
    private int getLength(ListNode head) {
        int length = 0;
        ListNode runner = head;
        while (runner != null) {
            length++;
            runner = runner.next;
        }
        return length;
    }
}