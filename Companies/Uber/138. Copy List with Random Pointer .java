/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        while (runner != null) {
            RandomListNode copy = new RandomListNode(runner.label);
            map.put(runner, copy);
            runner = runner.next;
        }
        runner = head;
        while (runner != null) {
            map.get(runner).random = map.get(runner.random);
            map.get(runner).next = map.get(runner.next);
            runner = runner.next;
        }
        return map.get(head);
    }
}