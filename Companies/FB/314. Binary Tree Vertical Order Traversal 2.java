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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.offer(root);
        level.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int curLevel = level.poll();
                min = Math.min(min, curLevel);
                max = Math.max(max, curLevel);
                map.putIfAbsent(curLevel, new ArrayList<Integer>());
                map.get(curLevel).add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                    level.offer(curLevel - 1);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    level.offer(curLevel + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}