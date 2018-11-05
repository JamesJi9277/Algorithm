class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (res.size() == 0 || i > res.get(res.size() - 1)) {
                res.add(i);
            } else if (i < res.get(0)) {
                res.set(0, i);
            } else {
                int index = search(res, i);
                res.set(index, i);
            }
        }
        return res.size();
    }
    private int search(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums.get(start) >= target) {
            return start;
        } else {
            return end;
        }
    }
}