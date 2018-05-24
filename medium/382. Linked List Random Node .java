https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain
http://blog.jobbole.com/42550/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        for (int i = 1; temp.next != null; i++) {
            temp = temp.next;
            // nextint generate int between 0 to i + 1
            // 0 is inclusive, i + 1 is exclusive
            // 保证当随机数落到最后一个index的时候，我们就将随机数赋值为当前的node value
            if (random.nextInt(i + 1) == i) {
                res = temp.val;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */