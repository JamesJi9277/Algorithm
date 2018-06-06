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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        helper(root, map);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> (e2.getValue() - e1.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        List<Integer> res = new ArrayList<Integer>();
        int max = pq.peek().getValue();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            } else {
                break;
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index++] = i;
        }
        return result;
    }
    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left, map);
        int rightSum = helper(root.right, map);
        int total = leftSum + rightSum + root.val;
        map.put(total, map.getOrDefault(total, 0) + 1);
        return total;
    }
}