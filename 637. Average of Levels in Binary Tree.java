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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                temp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            double average = getAverage(temp);
            result.add(average);
        }
        return result;
    }
    private double getAverage(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return (double)0;
        }
        Long size = (long) list.size();
        Long sum = 0L;
        for(int i : list) {
            sum += (long)i;
        }
        return (double)sum/size;
    }
}