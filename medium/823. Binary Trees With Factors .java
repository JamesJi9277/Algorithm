class Solution {
    public int numFactoredBinaryTrees(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mod = 1000000007;
        Arrays.sort(nums);
        HashMap<Integer, Long> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long count = 1;
            for (int j : map.keySet()) {
                if (nums[i] % j == 0 && map.containsKey(nums[i] / j)) {
                     count += map.get(j) * map.get(nums[i] / j);
                }
            }
            map.put(nums[i], count);
            res = (res + count) % mod;
        }
        return (int)res;
    }
}