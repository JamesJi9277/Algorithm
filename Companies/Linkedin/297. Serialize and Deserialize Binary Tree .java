public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }        
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    sb.append("#");
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
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < strs.length; i++) {
            TreeNode temp = queue.poll();
            if (!strs[i].equals("#")) {
                temp.left = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(temp.left);
            }
            if (!strs[i + 1].equals("#")) {
                temp.right = new TreeNode(Integer.valueOf(strs[i + 1]));
                queue.offer(temp.right);
            }
            i++;
        }
        return root;
    }
}