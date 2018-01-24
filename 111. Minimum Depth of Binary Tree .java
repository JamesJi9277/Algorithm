/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left != null && root.right == null) {
            return left + 1;
        }
        if (root.left == null && root.right != null) {
            return right + 1;
        }
        return Math.min(left, right) + 1;
    }
}


class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            while (size-- > 0) {
                root = deque.poll();
                if (root.left == null && root.right == null) {
                    min = Math.min(min, depth);
                }
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
            }
        }
        return min;
    }
}