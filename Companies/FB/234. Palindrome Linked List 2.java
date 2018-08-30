/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        next = reverse(next);
        while (head != null && next != null) {
            if (head.val != next.val) {
                return false;
            }
            head = head.next;
            next = next.next;
        }
        // can not directly check both are null, because there exist 
        // odd number case
        return true;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}