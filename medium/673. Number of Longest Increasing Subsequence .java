class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lens = new int[nums.length];
        int[] count = new int[nums.length];
        int global = 1;
        int globalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempLen = 1;
            int tempCount = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (lens[j] + 1 == tempLen) {
                        tempCount += count[j];
                    } else if (lens[j] + 1 > tempLen) {
                        tempCount = count[j];
                        tempLen = lens[j] + 1;
                    }
                }
            }
            if (tempLen == global) {
                globalCount += tempCount;
            }
            if (tempLen > global){
                global = tempLen;
                globalCount = tempCount;
            }
            lens[i] = tempLen;
            count[i] = tempCount;
        }
        
        return globalCount;
    }
}