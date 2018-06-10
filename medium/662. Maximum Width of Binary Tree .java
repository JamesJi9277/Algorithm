https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106654/JavaC++-Very-simple-dfs-solution

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}


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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue1.offer(root);
        queue2.offer(1);
        int max = 0;
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            int localMin = Integer.MAX_VALUE;
            int localMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue1.poll();
                int index = queue2.poll();
                localMin = Math.min(localMin, index);
                localMax = Math.max(localMax, index);
                if (temp.left != null) {
                    queue1.offer(temp.left);
                    queue2.offer(2 * index);
                }
                if (temp.right != null) {
                    queue1.offer(temp.right);
                    queue2.offer(2 * index + 1);
                }
            }
            max = Math.max(max, localMax - localMin + 1);
        }
        return max;
    }
}