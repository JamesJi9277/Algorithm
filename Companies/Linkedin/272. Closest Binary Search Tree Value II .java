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