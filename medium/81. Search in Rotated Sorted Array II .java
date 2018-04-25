class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
}