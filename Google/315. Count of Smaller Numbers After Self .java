class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] bit = new int[nums.length + 1];
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(sorted[i], i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0, getSum(bit, map.get(nums[i]) - 1));
            update(bit, map.get(nums[i]), 1);
        }
        return res;
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
    private void update(int[] bit, int index, int value) {
        for (int i = index + 1; i < bit.length; i += (i & (-i))) {
            bit[i] += value;
        }
    }
}