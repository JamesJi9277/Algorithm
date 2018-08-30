// On2, O1
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        while (left < nums.length) {
            int right = left;
            int diff = 0;
            while (right < nums.length) {
                if (nums[right] == 1) {
                    diff++;
                } else {
                    diff--;
                }
                if (diff == 0) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
            left++;
        }
        return max;
    }
}

// On, On
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preSum--;
            } else {
                preSum++;
            }
            if (preSum == 0) {
                max = Math.max(max, i + 1);
            } else if (map.containsKey(preSum)) {
                // sum between i and previous same sum is zero
                // find an interval
                max = Math.max(max, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return max;
    }
}