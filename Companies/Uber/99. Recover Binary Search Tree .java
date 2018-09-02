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
    public void recoverTree(TreeNode root) {
        // moris traversal and use first and second to record
        if (root == null) {
            return;
        }
        TreeNode first = null;
        TreeNode second = null;
        TreeNode temp = null;
        TreeNode prev = null;
        while (root != null) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    //do something
                    if (prev != null && prev.val > root.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = root;
                    }
                    prev = root;
                    
                    temp.right = null;
                    root = root.right;
                }
            } else {
                // do something
                if (prev != null && prev.val > root.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = root;
                }
                prev = root;
                
                root = root.right;
            }
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}