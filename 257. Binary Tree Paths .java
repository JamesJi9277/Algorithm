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
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, "", result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            helper(root.right, path + root.val + "->", result);
        }
    }
}