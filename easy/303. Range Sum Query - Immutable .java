class NumArray {
    int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = (i == 0) ? nums[0] : prefixSum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }
}