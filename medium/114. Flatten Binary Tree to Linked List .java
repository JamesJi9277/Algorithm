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
    public void flatten(TreeNode root) {
         if (root == null) {
             return;
         }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            flatten(root.right);
        } else {
            flatten(root.right);
            TreeNode right = root.right;
            flatten(root.left);
            TreeNode left = root.left;
            TreeNode temp = left;
            while (temp.right != null) {
                temp = temp.right;
            }
            root.left = null;
            root.right = left;
            temp.right = right;
        }
    }
}