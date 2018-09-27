class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            helper(res, child);
        }
        res.add(root.val);
    }
}

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            res.add(0, temp.val);
            for (Node child : temp.children) {
                stack.push(child);
            }
        }
        return res;
    }
}