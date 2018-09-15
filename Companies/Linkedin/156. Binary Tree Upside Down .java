class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return left;
    }
}

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode newRoot = stack.pop();
        TreeNode cur = newRoot;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            cur.left = node.right;
            cur.right = node;
            node.left = null;
            node.right = null;
            cur = node;
        }
        return newRoot;
    }
}