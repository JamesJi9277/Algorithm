// preorder
public class preorderIterator {
	Stack<TreeNode> stack;
	public preorderIterator(TreeNode root) {
		stack = new Stack<>();
		if (root != null) {
			stack.push(root);
		}
	}
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	public int next() {
		if (!hasNext()) {
			return 0;
		}
		TreeNode temp = stack.pop();
		int res = temp.val;
		if (temp.right != null) {
			stack.push(temp.right);
		}
		if (temp.left != null) {
			stack.push(temp.left);
		}
		return res;
	}
}
// inorder
public class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
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
        if (!hasNext()) {
            return 0;
        }
        TreeNode temp = stack.pop();
        int res = temp.val;
        temp = temp.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return res;
    }
}


// postorder