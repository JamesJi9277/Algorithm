/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

time On 
space Ok 
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(root, target, k, deque);
        return (LinkedList)deque;
    }
    private void inorder(TreeNode root, double target, int k, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        inorder(root.left, target, k, deque);
        if (deque.size() < k) {
            deque.offerLast(root.val);
        } else {
            if (Math.abs(deque.peekFirst() - target) > Math.abs(root.val - target)) {
                deque.pollFirst();
                deque.offer(root.val);
            }
        }
        inorder(root.right, target, k, deque);
    }
}

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
         
        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();
         
        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);
         
        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }
         
        return result;
    }
     
    private void getPredecessor(TreeNode root, double target, Stack<Integer> precedessor) {
        if (root == null) {
            return;
        }
         
        getPredecessor(root.left, target, precedessor);
         
        if (root.val > target) {
            return;
        }
         
        precedessor.push(root.val);
         
        getPredecessor(root.right, target, precedessor);
    }
     
    private void getSuccessor(TreeNode root, double target, Stack<Integer> successor) {
        if (root == null) {
            return;
        }
         
        getSuccessor(root.right, target, successor);
         
        if (root.val <= target) {
            return;
        }
         
        successor.push(root.val);
         
        getSuccessor(root.left, target, successor);
    }
}

class Solution {
    class Element {
        TreeNode node;
        double value;
        public Element(TreeNode node, double value) {
            this.node = node;
            this.value = value;
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> inorder = helper(root);
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> {
            if (a.value == b.value) {
                return 0;
            } else if (a.value > b.value) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int i : inorder) {
            Element e = new Element(new TreeNode(i), Math.abs((double)i - target));
            pq.offer(e);
        }
        while (k-- > 0) {
            res.add(pq.poll().node.val);
        }
        return res;
    }
    private List<Integer> helper(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}