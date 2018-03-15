public class Solution {
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        traverse(root, map);
        
        List<Integer> res = new ArrayList<>();
        for (int key: map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    private void traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        
        Integer value = map.getOrDefault(root.val, 0) + 1;
        max = Math.max(max, value);
        map.put(root.val, value);
        
        traverse(root.left, map);
        traverse(root.right, map);
    }
}