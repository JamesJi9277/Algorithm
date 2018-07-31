class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxLen = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLen[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 保持不变
                    if (maxLen[j] + 1 == maxLen[i]) {
                        count[i] += count[j];
                    }
                    if (maxLen[j] + 1 > maxLen[i]) {
                        maxLen[i] = maxLen[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (maxLen[i] == max) {
                maxCount += count[i];
            } else if (maxLen[i] > max) {
                max = maxLen[i];
                maxCount = count[i];
            }
        }
        return maxCount;
    }
}