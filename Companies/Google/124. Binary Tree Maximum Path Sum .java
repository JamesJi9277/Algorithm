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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        //全局
        max = Math.max(max, left + right + root.val);
        // 单边
        return Math.max(left, right) + root.val;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[]{Integer.MIN_VALUE};
        dfs(root, maxPath);
        return maxPath[0];
    }
    private int dfs(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left, maxPath), 0);
        int right = Math.max(dfs(root.right, maxPath), 0);
        maxPath[0] = Math.max(maxPath[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}