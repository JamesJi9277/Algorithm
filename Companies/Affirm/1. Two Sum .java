class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res = new int[]{map.get(target - nums[i]), i};
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}