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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0 || post == null || post.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, map);
    }
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int leftChildIndex = map.get(pre[preStart + 1]);
        int numLeft = leftChildIndex - postStart + 1;
        root.left = helper(pre, preStart + 1, preStart + numLeft, post, postStart, map);
        root.right = helper(pre, preStart + numLeft + 1, preEnd, post, leftChildIndex + 1, map);
        return root;
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0 || post == null || post.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, map);
    }
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int leftChild = pre[preStart + 1];
        int leftIndex = map.get(leftChild);
        int leftSize = leftIndex - postStart + 1;
        root.left = helper(pre, preStart + 1, preStart + leftSize, post, postStart, map);
        root.right = helper(pre, preStart + leftSize + 1, preEnd, post, leftIndex + 1, map);
        return root;
    }
}