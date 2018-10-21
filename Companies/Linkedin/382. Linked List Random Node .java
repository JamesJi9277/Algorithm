class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<Integer> list;
    Random random;
    public Solution(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        ListNode runner = head;
        while (runner != null) {
            list.add(runner.val);
            runner = runner.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

