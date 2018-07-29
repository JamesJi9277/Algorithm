class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = nums[i] - k;
            if (target == 0) {
                max = Math.max(max, i + 1);
            } else if (map.containsKey(target)) {
                max = Math.max(max, i - map.get(target));
            }
        }
        return max;
    }
}