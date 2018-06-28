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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        int count = countNode(root.left);
        if (k < count + 1) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        } else {
            return root.val;
        }
    }
    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return 1 + countNode(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + countNode(root.left);
        } else {
            return 1 + countNode(root.left) + countNode(root.right);
        }
    }
}