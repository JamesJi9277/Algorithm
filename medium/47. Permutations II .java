class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        int[] used = new int[nums.length];
        helper(nums, res, temp, used);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1 || (i != 0 && nums[i - 1] == nums[i] && used[i - 1] == 0)) {
                continue;
            }
            used[i] = 1;
            temp.add(nums[i]);
            helper(nums, res, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = 0;
        }
    }
}