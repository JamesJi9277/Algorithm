class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(sorted[i], i);
        }
        int[] bit = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = map.get(nums[i]);
            res.add(0, getSum(bit, index));
            update(bit, index + 1, 1);
        }
        return res;
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
    private void update(int[] bit, int index, int value) {
        
        for (int i = index; i < bit.length; i += (i & (-i))) {
            bit[i] += value;
        }
    }
}