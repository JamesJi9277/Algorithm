class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(helper(root), Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            max = Math.max(max, helper(root.left) + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            max = Math.max(max, helper(root.right) + 1);
        }
        return max;
    }
}

class Solution {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root.left, 1, root.val);
        helper(root.right, 1, root.val);
        return max;
    }
    private void helper(TreeNode root, int count, int prev) {
        if (root == null) {
            return;
        }
        if (root.val == prev + 1) {
            count++;
            max = Math.max(count, max);
            helper(root.left, count, root.val);
            helper(root.right, count, root.val);
        } else {
            helper(root.left, 1, root.val);
            helper(root.right, 1, root.val);
        }
    }
}
