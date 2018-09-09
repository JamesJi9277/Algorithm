class Solution {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        } else {
            int val = node.next.val;
            node.val = val;
            node.next = node.next.next;
        }
    }
}