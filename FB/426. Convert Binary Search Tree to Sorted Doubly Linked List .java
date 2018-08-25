/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            connect(root, root);
            return root;
        }
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        Node leftTail = (left == null) ? null : left.left;
        Node rightTail = (right == null) ? null : right.left;
        Node head = null;
        if (right == null) {
            head = left;
            connect(leftTail, root);
            connect(root, left);
        } else if (left == null) {
            head = root;
            connect(root, right);
            connect(rightTail, root);
        } else {
            head = left;
            connect(leftTail, root);
            connect(root, right);
            connect(rightTail, left);
        }
        return head;
    }
    private void connect(Node a, Node b) {
        a.right = b;
        b.left = a;
    }
}