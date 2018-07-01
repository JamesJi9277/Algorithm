//1. root to leaf to check if sum exists
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, res, temp);
        return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        helper(root.left, sum - root.val, res, temp);
        helper(root.right, sum - root.val, res, temp);
        temp.remove(temp.size() - 1);
    }
}
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, res, temp);
        return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(temp));temp.remove(temp.size() - 1);return;
        }
        helper(root.left, sum, res, temp);
        helper(root.right, sum, res, temp);
        temp.remove(temp.size() - 1);
    }
}


// 这是个好题
// 注意在调用的时候我是先调用startFrom然后和pathSum来计算child里面的结果的
// 这里千万要注意不要写错了
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return startFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int startFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + startFrom(root.left, sum - root.val) + startFrom(root.right, sum - root.val);
        } else {
            return startFrom(root.left, sum - root.val) + startFrom(root.right, sum - root.val);
        }
    }
}