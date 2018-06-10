/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode ptr = root;
        ListNode[] result = new ListNode[k];
        int len;
        
        for (len = 0; ptr != null; len++)
            ptr = ptr.next;
        
        int rem = len % k;
        int numPerPart = len / k;
        ptr = root;
        
        for (int i = 0; i < k && ptr != null; i++) {
            result[i] = ptr;
            
            for (int j = numPerPart - (rem > 0 ? 0 : 1); j > 0; j--)
                ptr = ptr.next;

            ListNode temp = ptr.next;
            ptr.next = null;
            ptr = temp;
            rem--;
        }
        
        return result;
    }
}