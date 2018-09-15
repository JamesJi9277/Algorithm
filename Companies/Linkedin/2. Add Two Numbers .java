class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            runner.next = new ListNode(temp);
            l1 = l1.next;
            l2 = l2.next;
            runner = runner.next;
        }
        while (l1 != null) {
            int temp = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            runner.next = new ListNode(temp);
            l1 = l1.next;
            runner = runner.next;
        }
        while (l2 != null) {
            int temp = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            runner.next = new ListNode(temp);
            l2 = l2.next;
            runner = runner.next;
        }
        if (carry == 1) {
            runner.next = new ListNode(1);
        }
        return dummy.next;
    }
}