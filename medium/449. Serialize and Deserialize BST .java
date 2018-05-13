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

    TreeNode root;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.root = root;
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("#");
                    sb.append(",");
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
        data = data.trim();
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode temp = queue.poll();
            if (!str[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                temp.left = left;
                queue.offer(left);
            }
            if(!str[i + 1].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(str[i + 1]));
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