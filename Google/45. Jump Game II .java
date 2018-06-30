class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxReach = 0;
        int reach = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                count++;
                maxReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return count;
    }
}