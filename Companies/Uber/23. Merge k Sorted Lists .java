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
    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = helper(lists, left, mid);
        ListNode rightNode = helper(lists, mid + 1, right);
        return mergeTwo(leftNode, rightNode);
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
                runner = runner.next;
                l2 = l2.next;
            } else {
                runner.next = l1;
                runner = runner.next;
                l1 = l1.next;
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