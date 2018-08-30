// this approach can reduce swap time
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                index++;
            } else {
                nums[nonZero] = nums[index];
                nonZero++;
                index++;
            }
        }
        for (int i = nonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

// this is for swap
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, nonZero);
                nonZero++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZero++] = nums[i];
            }
        }
        for (int i = nonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}