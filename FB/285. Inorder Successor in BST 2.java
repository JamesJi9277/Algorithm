class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (p.right != null) {
            return findLeftMost(p.right);
        } else {
            return findValidParent(root, p);
        }
    }
    private TreeNode findLeftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private TreeNode findValidParent(TreeNode root, TreeNode target) {
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null && cur != target) {
            if (cur.val > target.val) {
                prev = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return prev;
    }
}
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}