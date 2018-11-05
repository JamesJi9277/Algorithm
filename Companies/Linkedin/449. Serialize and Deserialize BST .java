/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return "";
        }
        helper(root, sb);
        return sb.toString();
    }
    private void helper(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper1(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode helper1(Queue<String> queue, int min, int max) {
        if (queue.isEmpty()) {
            return null;
        }
        String temp = queue.peek();
        int i = Integer.parseInt(temp);
        if (!(i > min && i < max)) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(i);
        root.left = helper1(queue, min, i);
        root.right = helper1(queue, i, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));