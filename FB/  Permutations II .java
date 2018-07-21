class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, temp, isUsed);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] isUsed) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i != 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) || isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            temp.add(nums[i]);
            helper(nums, res, temp, isUsed);
            temp.remove(temp.size() - 1);
            isUsed[i] = false;
        }
    }
}
// 时间On！
记得要先排序，这样子重复的元素在比较起来才会有意义
