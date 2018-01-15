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
    private ListNode mergeTwo(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        if (node1 == null || node2 == null) {
            return (node1 == null) ? node2 : node1;
        }
        ListNode runner = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                runner.next = node1;
                node1 = node1.next;
                runner = runner.next;
            } else {
                runner.next = node2;
                node2 = node2.next;
                runner = runner.next;
            }
        }
        if (node1 != null) {
            runner.next = node1;
        }
        if (node2 != null) {
            runner.next = node2;
        }
        return dummy.next;
    }
}

// below is exceeding time

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
        ListNode result = new ListNode(0);
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        result = mergeTwo(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            result = mergeTwo(lists[i], result);
        }
        return result;
    }
    private ListNode mergeTwo(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        if (node1 == null || node2 == null) {
            return (node1 == null) ? node2 : node1;
        }
        ListNode runner = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                runner.next = node1;
                node1 = node1.next;
                runner = runner.next;
            } else {
                runner.next = node2;
                node2 = node2.next;
                runner = runner.next;
            }
        }
        if (node1 != null) {
            runner.next = node1;
        }
        if (node2 != null) {
            runner.next = node2;
        }
        return dummy.next;
    }
}