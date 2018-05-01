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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res.size();
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            root = temp.right;
        }
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        TreeNode temp = root;
        while (temp != null) {
            left++;
            temp = temp.left;
        }
        int right = 0;
        temp = root;
        while (temp != null) {
            right++;
            temp = temp.right;
        }
        if (left == right) {
            return (1 << left) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}