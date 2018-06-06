class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int len = sum / 4;
        long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        return helper(nums, nums.length - 1, sum1, sum2, sum3, sum4, (long)len);
    }
    private boolean helper(int[] nums, int i, long sum1, long sum2, long sum3, long sum4, long len) {
        if (sum1 > len || sum2 > len || sum3 > len || sum4 > len) {
            return false;
        }
        if (i == -1) {
            if (sum1 == len && sum2 == len && sum3 == len && sum4 == len) {
                return true;
            } else 
            return false;
        }
        return helper(nums, i - 1, sum1 + nums[i], sum2, sum3, sum4, len) ||
            helper(nums, i - 1, sum1, sum2 + nums[i], sum3, sum4, len) || 
            helper(nums, i - 1, sum1, sum2, sum3 + nums[i], sum4, len) || 
            helper(nums, i - 1, sum1, sum2, sum3, sum4 + nums[i], len) ;
    }
}

class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        int count = 0;
        int[] visited = new int[nums.length];
        return helper(nums, count, visited, len, 0, 0);
    }
    private boolean helper(int[] nums, int count, int[] visited, int len, int cur, int index) {
        if (index == nums.length || cur > len) {
            return false;
        }
        if (cur == len) {
            count++;
            if (count == 3) {
                return true;
            } else {
                return helper(nums, count, visited, len, 0, 0);
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            } 
            visited[i] = 1;
            if (helper(nums, count, visited, len, cur + nums[index], i + 1)) {
                return true;
            }
            visited[i] = 0;
        }
        return false;
    }
}