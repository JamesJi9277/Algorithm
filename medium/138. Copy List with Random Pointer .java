//先复制node再复制random最后拆分
//直接复制node然后用hashmap存random
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        RandomListNode newHead = head.next;
        temp = head;
        while (temp != null) {
            RandomListNode node = temp.next;
            temp.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            temp = temp.next;
        }
        return newHead;
    }
}

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
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }
}