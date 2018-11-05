class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 表示在两边都找到了，则表示分布在两边
        // 如果是存在单边的情况，那么肯定left或者right有一个是null
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}