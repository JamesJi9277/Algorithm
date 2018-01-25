//这一题的关键是不能够破坏原有list的结构
//如果直接在原来list上进行reverse的话就破坏了list的结构
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode newHead = copy(head);
        newHead = reverse(newHead);
        while (head != null && newHead != null) {
            if (head.val == newHead.val) {
                head = head.next;
                newHead = newHead.next;
            } else {
                return false;
            }
            
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private ListNode copy(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            runner.next = temp;
            runner = runner.next;
            head = head.next;
        }
        return dummy.next;
    }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode runner = head;
        while (runner != null) {
            stack.push(runner);
            runner = runner.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = doReverse(newHead);
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode doReverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
