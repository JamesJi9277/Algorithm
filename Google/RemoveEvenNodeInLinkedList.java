public class Solution {
	public ListNode removeEven(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		while (cur != null) {
			if (cur.next != null && cur.next.next != null) {
				ListNode next = cur.next.next;
				cur.next.next = null;
				cur.next = next;
			} else {
				cur.next = null;
				cur = cur.next;
			}
		}
		return head;
	}
}