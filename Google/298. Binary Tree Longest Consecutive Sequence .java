class Solution {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root.left, 1, root.val);
        helper(root.right, 1, root.val);
        return max;
    }
    private void helper(TreeNode root, int cur, int prev) {
        if (root == null) {
            return;
        }
        if (root.val == prev + 1) {
            cur++;
            max = Math.max(max, cur);
            helper(root.left, cur, root.val);
            helper(root.right, cur, root.val);
        } else {
            helper(root.left, 1, root.val);
            helper(root.right, 1, root.val);
        }
    }
}