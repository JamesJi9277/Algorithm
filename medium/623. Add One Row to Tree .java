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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        TreeNode left; TreeNode right;
        if (d == 1){
            left = root;
            root = new TreeNode(v);
            root.left = left;
        }
        else if (d == 2){
            left = root.left;
            right = root.right;
            root.left = new TreeNode(v);
            root.left.left = left;
            root.right = new TreeNode(v);
            root.right.right = right;
        }
        else {
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
        }
        return root;
    }
}