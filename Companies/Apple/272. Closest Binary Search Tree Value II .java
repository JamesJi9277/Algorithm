class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        helper(root, target, k, deque);
        return (LinkedList)deque;
    }
    private void helper(TreeNode root, double target, int k, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        // mock inorder traversal order
        helper(root.left, target, k, deque);
        if (deque.size() < k) {
            deque.offer(root.val);
        } else {
            // if find, then just add to result
            if (Math.abs(deque.peekFirst() - target) > Math.abs(root.val - target)) {
                deque.pollFirst();
                deque.offer(root.val);
            } else {
                return;
            }
        }
        helper(root.right, target, k, deque);
    }
}