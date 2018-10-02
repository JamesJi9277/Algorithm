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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : G) {
            map.put(i, i);
        }
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head != null) {
            if (head != null && !map.containsKey(head.val)){
                head = head.next;
            }else{
                while (head != null && map.containsKey(head.val)){
                    head = head.next;
                }
                count++;
                if (head != null) {
                    head = head.next;
                }
            }
        }
        return count;
    }
}