class NumArray {

    int[] array;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        int sum = 0;
        array = new int[nums.length];
        while (index < nums.length) {
            sum += nums[index];
            array[index] = sum;
            index++;
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return array[j];
        } else {
            return array[j] - array[i - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */