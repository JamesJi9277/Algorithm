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
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
        } else if (N % 2 == 1) {
            for (int left = 1; left < N; left += 2) {
                List<TreeNode> leftSide = allPossibleFBT(left);
                List<TreeNode> rightSide = allPossibleFBT(N - left - 1);
                for (TreeNode n1 : leftSide) {
                    for (TreeNode n2 : rightSide) {
                        TreeNode root = new TreeNode(0);
                        root.left = n1;
                        root.right = n2;
                        res.add(root);
                    }
                }
            }
        }
        map.put(N, res);
        return map.get(N);
    }
}