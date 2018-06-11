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
    public List<List<String>> printTree(TreeNode root) {
        int arrLength = (int)(Math.pow(2,height(root))) - 1;
        List<List<String>> result = new ArrayList<List<String>>();
        for(int level=1;level<=height(root); level++){
            String[] levelStrArr = new String[arrLength];
            Arrays.fill(levelStrArr, "");
            levelOrder(levelStrArr, root, level, 0, arrLength);
            result.add(Arrays.asList(levelStrArr));
        }
        return result;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int max = left > right ? left : right;
        return max+1;
    }
    
    public void levelOrder(String[] levelList, TreeNode root, int level, int start, int end){
        if(root == null){
            return;
        }
        if(level == 1){
            levelList[(start+end)/2] = Integer.toString(root.val);
        }else{
            int mid = (start+end)/2;
            levelOrder(levelList, root.left, level-1, start, mid-1 );
            levelOrder(levelList, root.right, level-1, mid+1, end);
        }
    }
}