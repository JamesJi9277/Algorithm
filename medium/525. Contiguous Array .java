class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int preSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i] == 0 ? -1 : 1);
            if (preSum == 0) {
                max = i + 1;
            } else if (map.containsKey(preSum)) {
                max = Math.max(max, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return max;
    }
}

// 看见contiguious的array什么题目
//首先就可以想到是不是可以用hashmap来建立和与index之间的联系