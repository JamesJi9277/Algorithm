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


class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.right != null) {
            TreeNode temp = p.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            return findValidParent(root, p);
        }
    }
    private TreeNode findValidParent(TreeNode root, TreeNode target) {
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null && cur != target) {
            if (cur.val > target.val) {
                // cur is potential result
                // need to store that result
                prev = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return prev;
    }
}