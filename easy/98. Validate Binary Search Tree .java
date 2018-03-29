/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if ((long)root.val > min && (long)root.val < max) {
            return helper(root.left, min, (long)root.val) && helper(root.right, (long)root.val, max);
        }
        return false;
    }
}

// inorder traversal is increasing
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root);
    }
    private boolean helper(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i - 1) >= result.get(i)) {
                return false;
            }
        }
        return true;
    }
}