/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode temp) {
        stack = new Stack<>();
        root = temp;
        if (root == null) {
            return;
        }
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

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */