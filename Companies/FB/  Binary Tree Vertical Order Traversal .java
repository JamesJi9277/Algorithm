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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.offer(root);
        level.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int cur = level.poll();
                map.putIfAbsent(cur, new ArrayList<Integer>());
                map.get(cur).add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                    level.offer(cur - 1);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    level.offer(cur + 1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer item : map.keySet()) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}