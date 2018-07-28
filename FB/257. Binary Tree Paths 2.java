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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, "");
        return res;
    }
    private void helper(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += (root.val + "");
            res.add(new String(s));
            return;
        }
        helper(root.left, res, s + (root.val + "") + "->");
        helper(root.right, res, s + (root.val + "") + "->");
    }
}