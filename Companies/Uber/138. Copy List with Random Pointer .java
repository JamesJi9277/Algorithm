public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        while (runner != null) {
            map.put(runner, new RandomListNode(runner.label));
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