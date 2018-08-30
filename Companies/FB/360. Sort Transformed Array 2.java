class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // a > 0 or a == 0, we can add based from last based on two pointers value
        // a < 0, we can add from start based on two pointer value
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int index = (a >= 0) ? n - 1 : 0;
        while (left <= right) {
            if (a >= 0) {
                res[index--] = helper(nums[left], a, b, c) > helper(nums[right], a, b, c) ? helper(nums[left++], a, b, c) : helper(nums[right--], a, b, c);
            } else {
                res[index++] = helper(nums[left], a, b, c) < helper(nums[right], a, b, c) ? helper(nums[left++], a, b, c) : 
                helper(nums[right--], a, b, c);
            }
        }
        return res;
    }
    private int helper(int i, int a, int b, int c) {
        return a * i * i + b * i + c;
    }
}
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            res.add(helper(a, b, c, i));
        }
        Collections.sort(res);
        int index = 0;
        while (index < nums.length) {
            nums[index] = res.get(index++);
        }
        return nums;
    }
    private int helper(int a, int b, int c, int i) {
        return a * i * i + b * i + c;
    }
}