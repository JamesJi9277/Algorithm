class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode next = temp.next.next.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            second.next = first;
            first.next = next;
            temp.next = second;
            temp = first;
        }
        return dummy.next;
    }
}