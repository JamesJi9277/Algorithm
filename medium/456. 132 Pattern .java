On3
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int i = nums.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j] > nums[i]) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (nums[k] < nums[i]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

On2
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            min = Math.min(min, nums[j]);
            if (nums[j] == min) {
                continue;
            }
            for (int k = j + 1; k < nums.length; k++) {
                if (min < nums[k] && nums[j] > nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}


class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }
    
        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }
        
        return false;
    }
}