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
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return root;
        } else if (right > left) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return subtreeWithAllDeepest(root.left);
        }
    }
    private int getDepth(TreeNode root) {
        TreeNode temp = root;
        if (temp == null) {
            return 0;
        }
        if (temp.left == null && temp.right == null) {
            return 1;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}