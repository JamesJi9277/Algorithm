class NumArray {

    List<Integer> res;
    public NumArray(int[] nums) {
        res = new ArrayList<Integer>();
        for (int i : nums) {
            res.add(i);
        }
    }
    
    public void update(int i, int val) {
        res.set(i, val);
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += res.get(k);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

 class NumArray {

    List<Integer> res;
    int[] preSum;
    public NumArray(int[] nums) {
        res = new ArrayList<Integer>();
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
            if (i > 0) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
        }
    }
    
    public void update(int i, int val) {
        int diff = res.get(i) - val;
        res.set(i, val);
        for (int k = i; k < res.size(); k++) {
            preSum[k] -= diff;
        }
    }
    
    public int sumRange(int i, int j) {
        if (i > j) {
            return 0;
        }
        return preSum[j] - preSum[i] + res.get(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */