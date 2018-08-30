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

    StringBuffer sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuffer();
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    sb.append("#");
                    // 必须要加上空格来区分，以防负号这种符号
                    sb.append(" ");
                } else {
                    sb.append(temp.val);
                    sb.append(" ");
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.trim().split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        for (int i = 1; i < strs.length; i++) {
            TreeNode temp = queue.poll();
            if (!strs[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                temp.left = left;
                queue.offer(left);
            }
            if (!strs[i + 1].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strs[i + 1]));
                temp.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));