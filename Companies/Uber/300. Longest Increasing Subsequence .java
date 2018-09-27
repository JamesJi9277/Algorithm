class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res.isEmpty() || res.get(res.size() - 1) < nums[i]) {
                res.add(nums[i]);
            } else if (nums[i] < res.get(0)) {
                res.set(0, nums[i]);
            } else {
                int index = search(res, nums[i]);
                res.set(index, nums[i]);
            }
        }
        return res.size();
    }
    private int search(List<Integer> res, int target) {
        int start = 0;
        int end = res.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res.get(mid) == target) {
                return mid;
            } else if (res.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (res.get(start) >= target) {
            return start;
        } else {
            return end;
        }
    }
}