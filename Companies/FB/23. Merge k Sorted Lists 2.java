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
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                runner.next = l2;
                l2 = l2.next;
                runner = runner.next;
            } else {
                runner.next = l1;
                l1 = l1.next;
                runner = runner.next;
            }
        }
        if (l1 != null) {
            runner.next = l1;
        }
        if (l2 != null) {
            runner.next = l2;
        }
        return dummy.next;
    }
}