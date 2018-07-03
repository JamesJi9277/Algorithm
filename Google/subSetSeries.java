class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, res, temp, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, res, temp, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}