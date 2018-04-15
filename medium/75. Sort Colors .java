class Solution {
    public void sortColors(int[] nums) {
        //Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return;
        }
        int runner = 0;
        int red = 0;
        int blue = nums.length - 1;
        while (runner <= blue) {
            if (nums[runner] == 1) {
                runner++;
            } else if (nums[runner] == 0) {
                swap(nums, runner, red);
                red++;
                runner++;
            } else {
                // 因为这里我不确定swap过来的是0还是1
                swap(nums, runner, blue);
                blue--;
            }
        }
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        helper(nums, 0, nums.length - 1);
        return;
    }
    private void helper(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        helper(nums, start, left - 1);
        helper(nums, left + 1, end);
    }
}
