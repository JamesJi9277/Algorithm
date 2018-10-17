class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    public int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += (helper(root.left.left, map) + helper(root.left.right, map));
        }
        if (root.right != null) {
            robRoot += (helper(root.right.left, map) + helper(root.right.right, map));
        }
        int max = Math.max(robRoot, helper(root.left, map) + helper(root.right, map));
        map.put(root, max);
        return max;
    }
}