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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + len - 1);
        root.right =helper(inorder, rootIndex + 1, inEnd, postorder, postStart + len, postEnd - 1);
        return root;
    }
}