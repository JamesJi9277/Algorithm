class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    } }

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] isUsed = new int[nums.length];
        helper(nums, res, temp, isUsed);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int[] isUsed) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == 1 || (i != 0 && isUsed[i - 1] == 0 && nums[i - 1] == nums[i])) {
                continue;
            }
            isUsed[i] = 1;
            temp.add(nums[i]);
            helper(nums, res, temp, isUsed);
            temp.remove(temp.size() - 1);
            isUsed[i] = 0;
        }
    }
}