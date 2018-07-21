class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return  Math.max(diameterOfBinaryTree(root.left), Math.max(diameterOfBinaryTree(root.right), left + right));
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}