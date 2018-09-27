class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        if (temp == null) {
            head = null;
        } else {
            temp.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}