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


class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] bit = new int[nums.length + 1];
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        nums = reverse(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(sorted[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
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
    private int[] reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}