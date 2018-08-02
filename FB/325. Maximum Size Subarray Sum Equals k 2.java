public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        map.put(0, -1);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i] - k)) {
                max = Math.max(max, i - map.get(nums[i] - k));
            }
        }
        return max;
    }
}