class NumArray {

    int[] bit;
    int[] copy;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        bit = new int[nums.length + 1];
        copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int x, int val) {
        int diff = val - copy[x];
        copy[x] = val;
        for (int i = x + 1; i <= copy.length; i += (i & (-i))) {
            bit[i] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    private int getSum(int index) {
        index++;
        int res = 0;
        while (index > 0) {
            res += bit[index];
            index -= (index & (-index));
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */