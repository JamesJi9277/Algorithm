class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            helper(res, child);
        }
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            res.add(temp.val);
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }
        return res;
    }
}