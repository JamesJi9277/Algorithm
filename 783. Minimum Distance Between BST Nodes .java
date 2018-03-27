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
    int min = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return min;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        // 针对于右边来说，能够产生minDiff的就只有root了，也就是说最大的有关联的就是root
        pre = root.val;
        helper(root.right);
    }
}