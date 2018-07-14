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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        int diff = getDepth(root.left) - getDepth(root.right);
        if (diff > 0) {
            return subtreeWithAllDeepest(root.left);
        } else if (diff < 0) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return root;
        }
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}