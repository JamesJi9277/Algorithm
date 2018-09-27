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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(1);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int index = queue1.poll();
                min = Math.min(min, index);
                max = Math.max(max, index);
                if (temp.left != null) {
                    queue.offer(temp.left);
                    queue1.offer(index * 2);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    queue1.offer(index * 2 + 1);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
}