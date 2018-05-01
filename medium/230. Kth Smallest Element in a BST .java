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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        List<Integer> res = helper(root);
        return res.get(k - 1);
    }
    private List<Integer> helper(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        int count = countNode(root.left);
        if (k < count + 1) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        } else {
            return root.val;
        }
    }
    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return countNode(root.right) + 1;
        } else if (root.right == null && root.left != null) {
            return countNode(root.left) + 1;
        } else {
            return countNode(root.left) + countNode(root.right) + 1;
        }
    }
}