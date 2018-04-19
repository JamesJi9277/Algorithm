/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(next));
    }
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return (head1 == null)? head2 : head1;
        }
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (runner1 != null && runner2 != null) {
            if (runner1.val < runner2.val) {
                runner.next = runner1;
                runner1 = runner1.next;
                runner = runner.next;
            } else {
                runner.next = runner2;
                runner2 = runner2.next;
                runner = runner.next;
            }
        }
        while (runner1 != null) {
            runner.next = runner1;
            break;
        }
        while (runner2 != null) {
            runner.next = runner2;
            break;
        }
        return dummy.next;
    }
}