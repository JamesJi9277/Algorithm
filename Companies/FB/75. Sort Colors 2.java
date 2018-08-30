class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int count1 = 0;
        int count0 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int index = 0;
        while (count0 > 0) {
            nums[index++] = 0;
            count0--;
        }
        while (count1 > 0) {
            nums[index++] = 1;
            count1--;
        }
        while (count2 > 0) {
            nums[index++] = 2;
            count2--;
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nextZero = 0;
        int nextTwo = nums.length - 1;
        int runner = 0;
        while (runner <= nextTwo) {
            if (nums[runner] == 0) {
                swap(nums, runner, nextZero);
                nextZero++;
                runner++;
            } else if (nums[runner] == 2) {
                swap(nums, runner, nextTwo);
                nextTwo--;
            } else {
                runner++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}