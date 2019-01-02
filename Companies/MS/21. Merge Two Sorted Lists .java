class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
                runner = runner.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
                runner = runner.next;
            }
        }
        if (l1 != null) {
            runner.next = l1;  
        } else {
            runner.next = l2;
        }
        return dummy.next;
    }
}