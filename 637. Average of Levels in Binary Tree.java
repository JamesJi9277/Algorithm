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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = deque.size();
            while (size-- > 0) {
                root = deque.poll();
                temp.add(root.val);
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
            }
            result.add(getAve(temp));
        }
        return result;
    }
    private double getAve(List<Integer> list) {
        double sum = 0;
        for (int i : list) {
            sum += (double)i;
        }
        return (double)sum / list.size();
    }
}