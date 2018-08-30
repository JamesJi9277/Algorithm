//这一题要注意查重的问题
//或者可以问面试官nums里面首先有没有dup
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int first = 0;
        while (first < nums.length - 2) {
            int left = first + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if (!res.contains(temp)) {
                        res.add(temp);
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            first++;
        }
        return res;
    }
}