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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Set<Integer> set = new TreeSet<Integer>();
        helper(root, set);
        Iterator<Integer> iter = set.iterator();
        int count = 0;
        while (iter.hasNext()) {
            count++;
            int result = iter.next();
            if (count == 2) {
                return result;
            }
        }
        return -1;
    }
    private void helper(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }
}