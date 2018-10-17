/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                count++;
                set.remove(head.val);
                while (head.next != null && set.contains(head.next.val)) {
                    set.remove(head.next.val);
                    head = head.next;
                }
            }
            head = head.next;
        }
        return count;
    }
}