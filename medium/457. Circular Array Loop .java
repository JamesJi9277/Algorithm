class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int index = 0;
        boolean pass = false;
        for (int i = 0; i < nums.length; i++) {
            int newIndex = index + nums[index];
            if (newIndex >= nums.length) {
                pass = true;
            }
            index = newIndex % nums.length;
            if (index < 0) {
                index += nums.length;
                pass = true;
            }
            if (index == 0 && pass == true) {
                return true;
            }
        }
        return false;
    }
}