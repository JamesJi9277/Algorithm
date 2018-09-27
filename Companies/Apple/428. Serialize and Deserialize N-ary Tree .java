class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        helper(sb, root);
        return sb.toString();
    }
    private void helper(StringBuffer sb, Node root) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        sb.append(root.children.size());
        sb.append(" ");
        for (Node child : root.children) {
            helper(sb, child);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(" ");
        return helper(strs, new int[1]);
    }
    public Node helper(String[] nodes, int[] index) {
        int val = Integer.parseInt(nodes[index[0]++]);
        Node root = new Node(val, new ArrayList<Node>());
        int size = Integer.parseInt(nodes[index[0]++]);
        for (int i = 0; i < size; i++) {
            root.children.add(helper(nodes, index));
        }
        
        return root;
    }
}
