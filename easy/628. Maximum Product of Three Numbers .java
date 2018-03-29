class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        //要么是最大的三个正数
        //要么是最大的一个正数加上最小的两个负数
        // 这个corner case要考虑到
        Arrays.sort(nums);
        // 也可以保存五个变量来做，节省时间，这样只需要On而不是Onlogn来排序
        return Math.max(nums[nums.length - 1]* nums[nums.length - 2] * nums[nums.length - 3], nums[nums.length - 1]*nums[0] * nums[1]);
    }
}