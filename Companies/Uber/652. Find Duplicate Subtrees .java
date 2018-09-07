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
        helper(root, map, res);
        return res;
    }
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, map, res);
        String right = helper(root.right, map, res);
        String cur = root.val + left + right;
        if (map.containsKey(cur) && map.get(cur) == 1) {
            res.add(root);
            map.put(cur, map.get(cur) + 1);
        } else if (!map.containsKey(cur)) {
            map.put(cur, 1);
        }
        return cur;
    }
}