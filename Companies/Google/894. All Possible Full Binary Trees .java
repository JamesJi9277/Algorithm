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
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        if (N == 0) {
            return new ArrayList<TreeNode>();
        }
        if (N == 1) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        map.put(N, res);
        return res;
    }
}