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


// 写这种题要小心，并且还要仔细
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 0) {
            return lists[0];
        }
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left =  helper(lists, start, mid);
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
        }if (runner2 != null) {
            runner.next = runner2;
        }
        return dummy.next;
    }
}


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
            if (runner1.val < runner2.val) {
                runner.next = runner1;
                runner = runner.next;
                runner1 = runner1.next;
            } else {
                runner.next = runner2;
                runner = runner.next;
                runner2 = runner2.next;
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