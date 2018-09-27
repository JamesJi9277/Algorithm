class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (isUni(root, root.val)) {
            res++;
        }
        return res + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }
    private boolean isUni(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return isUni(root.left, val) && isUni(root.right, val);
    }
}