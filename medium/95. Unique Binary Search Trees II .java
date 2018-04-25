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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int m = start; m <= end; m++) {
            List<TreeNode> left = helper(start, m - 1);
            List<TreeNode> right = helper(m + 1, end);
            for (TreeNode i : left) {
                for (TreeNode j : right) {
                    TreeNode root = new TreeNode(m);
                    root.left = i;
                    root.right = j;
                    res.add(root);
                }
            }
        }
        return res;
    }
}