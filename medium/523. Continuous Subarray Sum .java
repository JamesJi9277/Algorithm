class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer index = map.get(sum);
            if (index == null) {
                map.put(sum, i);
            } else {
                if (i - index > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}