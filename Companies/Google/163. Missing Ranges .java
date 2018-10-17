class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(getString(lower, upper));
            return res;
        }
        if (upper < lower || nums[0] < lower || nums[nums.length - 1] > upper) {
            return res;
        }
        if (nums[0] != lower) {
            res.add(getString(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            if ((long)nums[i] - (long)nums[i - 1] >= 2) {
                res.add(getString(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] != upper) {
            res.add(getString(nums[nums.length - 1] + 1, upper));
        }
        return res;        
    }
    private String getString(int lower, int upper) {
        if (lower == upper) {
            return "" + lower;
        } else {
            return "" + lower + "->" + upper;
        }
    }
}