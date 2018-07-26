class Solution {
    public int removeDuplicates(int[] nums) {
        // this is a good problem
        if (nums.length < 3) {
            return nums.length;
        }
        int end = 2;
        for (int start = 2; start < nums.length; start++) {
            if (nums[start] != nums[end - 2]) {
                nums[end++] = nums[start];
            }
        }
        return end;
    }
}