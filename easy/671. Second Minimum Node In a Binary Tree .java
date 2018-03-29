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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Set<Integer> set = new TreeSet<Integer>();
        helper(root, set);
        Iterator<Integer> iter = set.iterator();
        int count = 0;
        while (iter.hasNext()) {
            int result = iter.next();
            count++;
            if (count == 2) {
                return result;
            }
        }
        return -1;
    }
    private void helper(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }
}

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}