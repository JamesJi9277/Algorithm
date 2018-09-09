class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        while (runner.next != null && runner.next.next != null) {
            ListNode first = runner.next;
            ListNode second = first.next;
            ListNode third = second.next;
            second.next = first;
            first.next = third;
            runner.next = second;
            runner = first;
        }
        return dummy.next;
    }
}