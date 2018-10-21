class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null) || left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode temp1 = stack1.pop();
            TreeNode temp2 = stack2.pop();
            if (temp1 == null && temp2 == null) {
                continue;
            }
            if (temp1 == null || temp2 == null) {
                return false;
            }
            if (temp1.val != temp2.val) {
                return false;
            }
            stack1.push(temp1.left);
            stack1.push(temp1.right);
            stack2.push(temp2.right);
            stack2.push(temp2.left);
        }
        return true;
    }
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}