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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(res, temp, root, sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            // 这里是个关键
            // 因为temp还会往下面继续传递，所以如果满足条件的话只需要加一个copy就好
            res.add(new ArrayList<Integer>(temp));
        }
        helper(res, temp, root.left, sum - root.val);
        helper(res, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);
    }
}


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, root, sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        helper(res, temp, root.left, sum - root.val);
        temp.remove(temp.size() - 1);
        temp.add(root.val);
        helper(res, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);
    }
}