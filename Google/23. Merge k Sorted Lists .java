/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwo(left, right);
    }
    private ListNode mergeTwo(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        while (runner1 != null && runner2 != null) {
            if (runner1.val > runner2.val) {
                runner.next = runner2;
                runner = runner.next;
                runner2 = runner2.next;
            } else {
                runner.next = runner1;
                runner = runner.next;
                runner1 = runner1.next;
            }
        }
        if (runner1 != null) {
            runner.next = runner1;
        }
        if (runner2 != null) {
            runner.next = runner2;
        }
        return dummy.next;
    }
}