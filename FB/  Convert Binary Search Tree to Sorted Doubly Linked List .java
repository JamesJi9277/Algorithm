class Solution {
    Node pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        pre = dummy;
        helper(root);
        Node head = dummy.right;
        connect(pre, head);
        return head;
    }
    private void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        connect(pre, root);
        pre = root;
        helper(root.right);
    }
    private void connect(Node a, Node b) {
        a.right = b;
        b.left = a;
    }
}

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        Node pre = dummy;
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node temp = stack.pop();
            connect(pre, temp);
            pre = temp;
            cur = temp.right;
        }
        Node head = dummy.right;
        connect(pre, head);
        return head;
    }
    private void connect(Node a, Node b) {
        a.right = b;
        b.left = a;
    }
}