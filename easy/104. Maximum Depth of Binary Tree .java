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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }
}


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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        int max = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                root = deque.poll();
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
            }
            max++;
        }
        return max;
    }
}