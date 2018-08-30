/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode runner1 = headA;
        ListNode runner2 = headB;
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff-- > 0) {
                runner1 = runner1.next;
            }
        } else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            while (diff-- > 0) {
                runner2 = runner2.next;
            }
        }
        while (runner1 != null && runner2 != null) {
            if (runner1 == runner2) {
                return runner1;
            }
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return null;
    }
    private int getLength(ListNode node) {
        int count = 0;
        ListNode temp = node;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}