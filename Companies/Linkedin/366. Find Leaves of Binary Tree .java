class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }
    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int level = Math.max(helper(res, root.left), helper(res, root.right)) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        return level;
    }
}