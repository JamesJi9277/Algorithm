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
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return crossRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int crossRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + crossRoot(root.left, sum - root.val) + crossRoot(root.right, sum - root.val);
        } else {
            return crossRoot(root.left, sum - root.val) + crossRoot(root.right, sum - root.val);
        }
    }
}