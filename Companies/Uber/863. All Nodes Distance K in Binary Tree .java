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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParent(parent, root, null);
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        queue.offer(target);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (step == K) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                break;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null && !set.contains(temp.left)) {
                        queue.offer(temp.left);
                        set.add(temp.left);
                    }
                    if (temp.right != null && !set.contains(temp.right)) {
                        queue.offer(temp.right);
                        set.add(temp.right);
                    }
                    if (parent.get(temp) != null && !set.contains(parent.get(temp))) {
                        queue.offer(parent.get(temp));
                        set.add(parent.get(temp));
                    }
                }
            }
            step++;
        }
        return res;
    }
    private void getParent(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        getParent(map, root.left, root);
        getParent(map, root.right, root);
    }
    public void getParent1(Map<TreeNode, TreeNode> parent, TreeNode root, TreeNode father){
        if(root == null){
            return;
        } 
        parent.put(root, father);
        getParent(parent, root.left, root);
        getParent(parent, root.right, root);
    }
}