class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int preZero = -1;
        int len = 0;
        // [left, i] is all 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = preZero + 1;
                preZero = i;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}

with k flips
int max = 0;
int zero = 0;
int left = 0;
for (int i = 0; i < nums.length; i++) {
    if (nums[i] == 0) {
        zero++;
    }
    while (zero > k) {
        if (nums[left] == 0) {
            left++;
            zero--;
        }
    }
    max = Math.max(max, i - left + 1);
}