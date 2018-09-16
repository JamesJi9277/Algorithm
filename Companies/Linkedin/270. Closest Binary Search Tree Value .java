class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        double min = Double.POSITIVE_INFINITY;
        int res = 0;
        while (root != null) {
            if (Math.abs((double)root.val - target) < min) {
                min = Math.abs((double)root.val - target);
                res = root.val;
            }
            if (root.val == target) {
                return root.val;
            } else if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}