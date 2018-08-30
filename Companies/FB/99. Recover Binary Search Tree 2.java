class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        
        // here is prev, meaning large number
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        // pay attention
        // here is root, meaning small number
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}

class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                } 
                if (first != null) {
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}