class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int prev1 = cur;
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
// 将list分成两种情况
// 并且在判断的时候注意起点是(i + 1)
class Solution {
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    private int helper(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int cur = nums[start];
        int prev1 = nums[start];
        int prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}


// 递归，考虑rob root与否的两种情况
class Solution {
    public int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            robRoot += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(robRoot, rob(root.left) + rob(root.right));
    }
}

//但是方法1里面进行了多次的重复计算
//比如我再算root的child的时候就多次重复计算，所以用map来保存结果
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        return helper(root, map);
    }
    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        // avoid redundant caculation
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += (helper(root.left.left, map) + helper(root.left.right, map));
        }
        if (root.right != null) {
            robRoot += (helper(root.right.left, map) + helper(root.right.right, map));
        }
        int max =  Math.max(robRoot, helper(root.left, map) + helper(root.right, map));
        map.put(root, max);
        return max;
    }
}

class Solution {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]); // 0 represent max when root is not robbed, 1 stands for max when root is robbed
    }
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] robLeft = robSub(root.left);
        int[] robRight = robSub(root.right);
        int[] res = new int[2];
        res[0] = root.val + robLeft[1] + robRight[1]; // if rob root
        res[1] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        return res;
    }
}