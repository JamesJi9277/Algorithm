/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        helper(root, res, map);
        return res;
    }
    private String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, res, map);
        String right = helper(root.right, res, map);
        String path = root.val + left + right;
        if (map.containsKey(path) && map.get(path) == 1) {
            res.add(root);
            map.put(path, 2);
        } else if (!map.containsKey(path)) {
            map.put(path, 1);
        }
        return path;
    }
}