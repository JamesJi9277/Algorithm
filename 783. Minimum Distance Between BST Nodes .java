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
    int min = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return min;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        // 针对于右边来说，能够产生minDiff的就只有root了，也就是说最大的有关联的就是root
        pre = root.val;
        helper(root.right);
    }
}

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
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> inorder = inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inorder.size() - 1; i++) {
            min = Math.min(min, inorder.get(i + 1) - inorder.get(i));
        }
        return min;
    }
    private List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}