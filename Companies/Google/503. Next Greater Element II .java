class Solution {
    public int[] nextGreaterElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            res.add(i);
        }
        for (int i : nums) {
            res.add(i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int max = nums[i];
            int j;
            for (j = i + 1; j < res.size(); j++) {
                if (res.get(j) > max) {
                    result[i] = res.get(j);
                    break;
                }
            }
            if (j == res.size()) {
                result[i] = -1;
            }
        }
        return result;
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return res;
    }
}