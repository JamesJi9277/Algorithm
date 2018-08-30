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

public class Solution {
	public ListNode removeEven(Listnode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		while (temp != null) {
			if (temp.next != null && temp.next.next != null) {
				ListNode next = temp.next.next;
				temp.next.next = null;
				temp.next = next;
			} else {
				temp.next = null;
				temp = temp.next;
			}
		}
		return head;
	}
}