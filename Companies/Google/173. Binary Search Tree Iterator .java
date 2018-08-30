public class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            TreeNode temp = stack.pop();
            TreeNode cur = temp;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return temp.val;
        } 
        return 0;
    }
}